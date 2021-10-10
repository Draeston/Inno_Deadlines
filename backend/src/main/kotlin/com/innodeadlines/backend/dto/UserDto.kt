package com.innodeadlines.backend.dto

data class UserDto(
    var firstName: String = "",
    var lastName: String = "",
    var userPassword: String = "",
    var groupName: String = "",
    var email: String = "",
)
