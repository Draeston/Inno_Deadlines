package com.innodeadlines.backend.rest

import com.innodeadlines.backend.dao.GroupRepository
import com.innodeadlines.backend.model.Group
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/group")
class GroupController(
    private val groupRepository: GroupRepository,
) {

    @GetMapping("/all")
    fun getAllGroups(): Iterable<Group> {
        return groupRepository.findAll()
    }
}