package com.innodeadlines.backend.rest

import com.innodeadlines.backend.dao.GroupRepository
import com.innodeadlines.backend.dao.PendingRepository
import com.innodeadlines.backend.dao.UserRepository
import com.innodeadlines.backend.dto.UserDto
import com.innodeadlines.backend.model.PendingRegistration
import com.innodeadlines.backend.model.User
import com.innodeadlines.backend.smtp.EmailServiceImpl
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors


@RestController
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val pendingRepository: PendingRepository,
    private val groupRepository: GroupRepository,
    private val emailService: EmailServiceImpl
) {

    @GetMapping("/all")
    fun getAllUsers(): Iterable<User> {
        return userRepository.findAll()
    }

    @GetMapping("/id")
    fun getUserById(@RequestParam("id") id: Int): User? {
        return userRepository.findByIdOrNull(id)
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody newUser: UserDto): String {
        var newPending = PendingRegistration()
        var user: User = User()
        user.firstName = newUser.firstName
        user.lastName = newUser.lastName
        user.userPassword = newUser.userPassword
        user.groupId = groupRepository.findGroupIdByName(newUser.groupName)!!
        user.email = newUser.email
        val newEntry = userRepository.save(user)
        newPending.userId = newEntry.id
        val newPin = (1000..9999).random()
        newPending.pin = newPin
        pendingRepository.save(newPending)
        emailService.sendVerificationMessage(newEntry.email, "verification", newPin.toString())
        return "Registration done. Awaiting for confirmation"
    }

    @PostMapping("/confirm")
    fun confirmRegister(@RequestParam("email") email: String, @RequestParam("pin") pin: Int): String {
        if (userRepository.checkExistsUserByEmail(email)) {
            val user = userRepository.findUserByEmail(email)
            println(user.toString())
            val userId = user!!.id
            println(userId)
            if (userId != null) {
                val pendingEntry = pendingRepository.findPendingByUserId(userId)
                if (pin == pendingEntry.pin) {

                    pendingRepository.deleteById(pendingEntry.id)
                    return "Successful confirmation"
                } else
                    return "Confirmation failed"
            } else
                return "Confirmation failed"
        } else
            return "Confirmation failed"
    }

    @ResponseBody
    @PostMapping("/login")
    fun login(@RequestParam("email") email: String, @RequestParam("password") password: String): Any {
        if (userRepository.checkExistsUserByEmail(email)) {
            val tryUser = userRepository.findUserByEmail(email)
            if (tryUser!!.userPassword != password) {
                return "Wrong password."
            }
            if (pendingRepository.existsPendingByUserId(tryUser!!.id)) {
                return "Account not confirmed."
            } else {
                val token = getJWTToken(email)
                var user = User()
                user.email = email
                user.token = token
                return user
            }
        } else
            return "Account with such email does not exists."
    }

    @GetMapping("/check")
    fun checkAuth(): String {
        return "Successful authorization!"
    }

    private fun getJWTToken(username: String): String {
        val secretKey = "mySecretKey"
        val grantedAuthorities = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_USER")
        val token = Jwts
            .builder()
            .setId("softtekJWT")
            .setSubject(username)
            .claim("authorities",
                grantedAuthorities.stream()
                    .map { obj: GrantedAuthority -> obj.authority }
                    .collect(Collectors.toList()))
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 600000))
            .signWith(
                SignatureAlgorithm.HS512,
                secretKey.toByteArray()
            ).compact()
        return "Bearer $token"
    }

}