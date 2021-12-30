package com.jay.login.service

import com.jay.login.entity.User
import com.jay.login.model.request.UserRequest
import com.jay.login.model.response.UserResponse
import com.jay.login.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun register(request: UserRequest): UserResponse {
        if (userRepository.findById(request.id)?.isNotEmpty() == true) {
            throw Exception("ID already exist")
        }

        val user = userRepository.save(User(request))
        return UserResponse(user)
    }
}