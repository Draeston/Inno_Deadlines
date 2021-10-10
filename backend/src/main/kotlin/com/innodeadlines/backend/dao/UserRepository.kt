package com.innodeadlines.backend.dao

import com.innodeadlines.backend.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<User, Int> {

    @Query(value = "SELECT * FROM users u WHERE u.email = :find_email LIMIT 1", nativeQuery = true)
    fun findUserByEmail(@Param("find_email") findEmail: String): User?

    @Query(value = "SELECT EXISTS (SELECT id FROM users u WHERE u.email = :find_email LIMIT 1)", nativeQuery = true)
    fun checkExistsUserByEmail(@Param("find_email") findEmail: String): Boolean

}