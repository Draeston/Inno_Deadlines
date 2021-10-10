package com.innodeadlines.backend.dao

import com.innodeadlines.backend.model.PendingRegistration
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PendingRepository : CrudRepository<PendingRegistration, Int> {

    @Query(value = "SELECT * FROM pending_registration p WHERE p.user_id = :find_id LIMIT 1", nativeQuery = true)
    fun findPendingByUserId(@Param("find_id") findId: Int): PendingRegistration

    @Query(
        value = "SELECT EXISTS (SELECT * FROM pending_registration p WHERE p.user_id = :find_id LIMIT 1)",
        nativeQuery = true
    )
    fun existsPendingByUserId(@Param("find_id") findId: Int): Boolean

}