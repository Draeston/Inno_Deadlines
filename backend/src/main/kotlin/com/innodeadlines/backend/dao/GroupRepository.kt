package com.innodeadlines.backend.dao

import com.innodeadlines.backend.model.Group
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface GroupRepository : CrudRepository<Group, Int> {

    @Query(value = "SELECT id FROM groups g WHERE g.group_name = :name LIMIT 1", nativeQuery = true)
    fun findGroupIdByName(@Param("name") name: String): Int?

    @Query(value = "SELECT assignment_id FROM group_assignments g WHERE g.group_id = :groupId", nativeQuery = true)
    fun getAssignmetIdsByGroupId(@Param("groupId") groupId: Int): List<Int>

}