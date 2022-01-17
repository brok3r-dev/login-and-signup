package com.jay.login.common

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class UserAuthority(val auth: MutableCollection<out GrantedAuthority>) {
    ROLE_MASTER(
        mutableListOf(
            SimpleGrantedAuthority("master:read"),
            SimpleGrantedAuthority("master:write")
        )
    ),
    ROLE_MANAGER(
        mutableListOf(
            SimpleGrantedAuthority("manager:read"),
            SimpleGrantedAuthority("manager:write")
        )
    ),
    ROLE_VIEWER(
        mutableListOf(
            SimpleGrantedAuthority("common:read"),
            SimpleGrantedAuthority("common:write")
        )
    )
}