package com.jay.login.controller

import com.jay.login.model.request.UserRequest
import com.jay.login.model.response.UserResponse
import com.jay.login.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(name = "/user")
class UserController(
    private val encoder: PasswordEncoder,
    private val userService: UserService
) {
    @PostMapping(name = "/register")
    @ResponseBody
    fun register(
        @RequestBody @Validated request: UserRequest
    ): UserResponse {
        request.password = encoder.encode(request.password)
        return userService.register(request)
    }
}