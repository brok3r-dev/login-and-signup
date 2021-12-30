package com.jay.login.common.handler

class UserException(
    val response: UserErrorResponse
) : RuntimeException() {
}