package com.jay.login.common.handler

import java.time.LocalDate
import java.sql.Date

data class UserErrorResponse(
    var code: UserErrorCode = UserErrorCode.USER_UNKNOWN_ERROR,
    var timestamp: Date = Date.valueOf(LocalDate.now())
) {
    constructor(message: String, code: UserErrorCode): this() {
        this.code = code
    }
}
