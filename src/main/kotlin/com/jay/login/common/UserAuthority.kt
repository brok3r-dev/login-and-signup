package com.jay.login.common

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class UserAuthority(val auth: MutableCollection<out GrantedAuthority>) {
    MASTER(
        mutableListOf(
            SimpleGrantedAuthority("master:read"),
            SimpleGrantedAuthority("master:write")
        )
    ),
    MANAGER(
        mutableListOf(
            SimpleGrantedAuthority("manager:read"),
            SimpleGrantedAuthority("manager:write")
        )
    ),
    COMMON(
        mutableListOf(
            SimpleGrantedAuthority("common:read"),
            SimpleGrantedAuthority("common:write")
        )
    )
}