package com.jay.login.entity

import com.jay.login.common.UserAuthority
import com.jay.login.common.emailValidation
import com.jay.login.common.handler.UserErrorCode
import com.jay.login.common.handler.UserErrorResponse
import com.jay.login.common.handler.UserException
import com.jay.login.common.idAndNameValidation
import com.jay.login.common.passwordValidation
import com.jay.login.model.request.UserRequest
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.sql.Date
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    var id: String? = null,

    @Column(name = "password", nullable = false)
    var userPassword: String? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "email", nullable = true, unique = true)
    var email: String? = null,

    @Column(name = "authority", nullable = false)
    var authority: String? = UserAuthority.ROLE_VIEWER.name,

    @Column(name = "non_expired", nullable = false)
    var nonExpired: Boolean? = true,

    @Column(name = "non_locked", nullable = false)
    var nonLocked: Boolean? = true,

    @Column(name = "credential_non_expired", nullable = false)
    var credentialNonExpired: Boolean? = true,

    @Column(name = "enabled", nullable = false)
    var enabled: Boolean? = true,

    @Column(name = "created_at", nullable = false)
    var createdAt: Date? = null,

    @Column(name = "modified_at", nullable = false)
    var modifiedAt: Date? = null
) : Serializable, UserDetails {
    constructor(request: UserRequest) : this() {
        this.id = request.id
        this.userPassword = request.password
        this.name = request.name
        this.email = request.email
        this.createdAt = Date.valueOf(LocalDate.now())
        this.modifiedAt = Date.valueOf(LocalDate.now())
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        this.authority?.let {
            return UserAuthority.valueOf(it).auth
        } ?: run {
            val response = UserErrorResponse(UserErrorCode.INVALID_AUTHORITY)
            throw UserException(response)
        }
    }

    override fun getPassword(): String = this.userPassword ?: throw Exception("Invalid Password")

    override fun getUsername(): String = this.name ?: throw Exception("Invalid Username")

    override fun isAccountNonExpired(): Boolean = this.nonExpired ?: false

    override fun isAccountNonLocked(): Boolean = this.nonLocked ?: false

    override fun isCredentialsNonExpired(): Boolean = this.credentialNonExpired ?: false

    override fun isEnabled(): Boolean = this.enabled ?: false
}