package com.innodeadlines.backend.dao

import com.innodeadlines.backend.model.Assignment
import org.springframework.data.repository.CrudRepository

interface AssignmentRepository : CrudRepository<Assignment, Int> {


}