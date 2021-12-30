package com.jay.login.repository

import com.jay.login.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findById(id: String): List<User>?
    fun findByName(name: String): List<User>?
    fun findByEmail(email: String): List<User>?
}