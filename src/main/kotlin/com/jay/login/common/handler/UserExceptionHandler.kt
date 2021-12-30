package com.jay.login.common.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class UserExceptionHandler {
    @ExceptionHandler(UserException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleUserException(ex: UserException) : ResponseEntity<UserErrorResponse> {
        val response = UserErrorResponse(ex.response.code)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}