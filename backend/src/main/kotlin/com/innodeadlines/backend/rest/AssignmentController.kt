package com.innodeadlines.backend.rest

import com.innodeadlines.backend.dao.AssignmentRepository
import com.innodeadlines.backend.dao.GroupRepository
import com.innodeadlines.backend.model.Assignment
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/assignment")
class AssignmentController(
    private val groupRepository: GroupRepository,
    private val assignmentRepository: AssignmentRepository
) {

    @GetMapping("allbygroup")
    fun getAllAssigments(groupName: String): MutableIterable<Assignment> {
        val groupId = groupRepository.findGroupIdByName(groupName)
        val assignmentIds = groupRepository.getAssignmetIdsByGroupId(groupId!!)
        return assignmentRepository.findAllById(assignmentIds)
    }

    @PostMapping("add")
    fun addAssignment(@RequestBody assignment: Assignment) {
        assignmentRepository.save(assignment)
    }

}