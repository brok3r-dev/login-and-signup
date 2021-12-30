package com.jay.login.controller

import com.jay.login.common.API_VERSION
import com.jay.login.model.request.UserRequest
import com.jay.login.model.response.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(name = "${API_VERSION}/user")
class UserController {
    @PostMapping(name = "/register")
    @ResponseBody
    fun register(
        @RequestBody request: UserRequest
    ): UserResponse {
        //TODO: create service
        return UserResponse()
    }
}