package com.innodeadlines.backend.model

import javax.persistence.*

@Entity
@Table(name = "pending_registration")
data class PendingRegistration(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    var userId: Int = 0,
    var pin: Int = 0
)
