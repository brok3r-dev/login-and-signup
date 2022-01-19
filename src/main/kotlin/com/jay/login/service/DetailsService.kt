package com.jay.login.service

import com.jay.login.common.handler.UserErrorCode
import com.jay.login.common.handler.UserErrorResponse
import com.jay.login.common.handler.UserException
import com.jay.login.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class DetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val user = userRepository.findById(id)
        user?.let {
            return it
        } ?: throw UserException(UserErrorResponse(UserErrorCode.USER_DOES_NOT_EXIST))
    }
}