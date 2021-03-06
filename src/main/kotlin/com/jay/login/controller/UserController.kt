package com.jay.login.controller

import com.jay.login.model.request.UserRequest
import com.jay.login.model.response.UserResponse
import com.jay.login.service.UserService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    @ResponseBody
    fun register(
        @RequestBody @Validated request: UserRequest
    ): UserResponse {
        return userService.register(request)
    }
}