package com.innodeadlines.backend.model

import javax.persistence.*

@Entity
@Table(name = "assignment_comments")
data class assignmentComment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    var assignmentId: Int = 0,
    var userId: Int = 0,
    var contents: String = ""
) {
}