package com.jay.login.service

import com.jay.login.common.emailValidation
import com.jay.login.common.handler.UserErrorCode
import com.jay.login.common.handler.UserErrorResponse
import com.jay.login.common.handler.UserException
import com.jay.login.common.idAndNameValidation
import com.jay.login.common.passwordValidation
import com.jay.login.entity.User
import com.jay.login.model.request.UserRequest
import com.jay.login.model.response.UserResponse
import com.jay.login.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) {
    fun register(request: UserRequest): UserResponse {
        if (userRepository.findById(request.id) != null) {
            val response = UserErrorResponse(UserErrorCode.USER_ALREADY_EXIST)
            throw UserException(response)
        }

        if (!idAndNameValidation(request.id)) {
            val response = UserErrorResponse(UserErrorCode.INVALID_ID_FORMAT)
            throw UserException(response)
        }

        if (!passwordValidation(request.password)) {
            val response = UserErrorResponse(UserErrorCode.INVALID_PASSWORD_FORMAT)
            throw UserException(response)
        } else {
            request.password = encoder.encode(request.password)
        }

        if (!idAndNameValidation(request.id)) {
            val response = UserErrorResponse(UserErrorCode.INVALID_NAME_FORMAT)
            throw UserException(response)
        }

        request.email?.let { email ->
            if (!emailValidation(email)) {
                val response = UserErrorResponse(UserErrorCode.INVALID_EMAIL_FORMAT)
                throw UserException(response)
            }
        }

        val user = User(request)
        return UserResponse(userRepository.save(user))
    }
}