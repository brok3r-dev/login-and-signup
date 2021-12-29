package com.jay.login.controller

import com.jay.login.common.API_VERSION
import com.jay.login.model.request.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "${API_VERSION}/user")
class UserController {
    @PostMapping(name = "/register")
    @PreAuthorize(value = "hasRole('')")
    fun register(
        @RequestBody request: UserRequest
    ): ResponseEntity<Any> {
        //TODO: create register service
        return ResponseEntity.ok("In Progress")
    }
}