package com.innodeadlines.backend.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var userPassword: String = "",
    var groupId: Int = 0,
    var email: String = "",
    var token: String = ""
)