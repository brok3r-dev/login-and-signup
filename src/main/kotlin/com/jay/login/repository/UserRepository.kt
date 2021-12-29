package com.jay.login.repository

import com.jay.login.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): List<User>?
    fun findByEmail(email: String): List<User>?
}