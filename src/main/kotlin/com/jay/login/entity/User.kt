package com.jay.login.entity

import com.jay.login.common.emailValidation
import com.jay.login.common.idAndNameValidation
import com.jay.login.common.passwordValidation
import com.jay.login.model.request.UserRequest
import lombok.NoArgsConstructor
import java.io.Serializable
import java.sql.Date
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
@NoArgsConstructor
data class User(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    var id: String? = null,

    @Column(name = "password", nullable = false)
    var password: String? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "email", nullable = true)
    var email: String? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: Date? = null,

    @Column(name = "modified_at", nullable = false)
    var modifiedAt: Date? = null
) : Serializable {
    constructor(request: UserRequest) : this() {
        if (idAndNameValidation(request.id)) {
            this.id = request.id
        } else {
            //TODO: validationError
        }

        if (passwordValidation(request.password)) {
            this.password = request.password
        } else {
            //TODO: validationError
        }

        if (idAndNameValidation(request.id)) {
            this.name = request.name
        } else {
            //TODO: validationError
        }

        request.email?.let { email ->
            if (emailValidation(email)) {
                this.email = email
            } else {
                //TODO: validationError
            }
        }

        this.createdAt = Date.valueOf(LocalDate.now())
        this.modifiedAt = Date.valueOf(LocalDate.now())
    }
}