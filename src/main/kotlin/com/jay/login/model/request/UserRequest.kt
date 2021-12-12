package com.jay.login.model.request

data class UserRequest(
    val id: String,
    val password: String,
    val name: String,
    val email: String?
)

