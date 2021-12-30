package com.jay.login.model.response

import com.jay.login.entity.User
import java.util.*

data class UserResponse(
    var name: String = "NULL",
    var email: String? = null,
    var authority: String = "NULL",
    var createdAt: Date = Date()
) {
    constructor(data: User): this() {
        data.name?.let {
            this.name = it
        } ?: throw Exception() //TODO: NULL Pointer

        data.email?.let {
            this.email = it
        }

        data.authority?.let {
            this. authority = it
        } ?: throw Exception() //TODO: NULL Pointer

        data.createdAt?.let {
            this.createdAt = it
        } ?: throw Exception() //TODO: NULL Pointer
    }
}