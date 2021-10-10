package com.innodeadlines.backend.model

import java.time.Instant
import javax.persistence.*


@Entity
@Table(name = "assignments")
data class Assignment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    var assignmentName: String = "",
    var assignmentDescription: String = "",
    var deadline: Instant = Instant.now()
) {

}