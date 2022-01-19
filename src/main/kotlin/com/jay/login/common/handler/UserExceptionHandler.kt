package com.jay.login.common.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class UserExceptionHandler {
    @ExceptionHandler(UserException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleUserException(ex: UserException): UserErrorResponse {
        return UserErrorResponse(ex.response.code)
    }
}