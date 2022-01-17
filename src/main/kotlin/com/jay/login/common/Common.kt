package com.jay.login.common

import java.util.regex.Pattern

const val ID_NAME_PATTERN: String = "^[A-Za-z0-9]{3,20}$"
fun idAndNameValidation(name: String) = Pattern.compile(ID_NAME_PATTERN).matcher(name).matches()

const val PASSWORD_PATTERN: String = "^[A-Za-z0-9!@#$%^&*]{8,20}$"
fun passwordValidation(password: String) = Pattern.compile(PASSWORD_PATTERN).matcher(password).matches()

const val EMAIL_PATTERN: String = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
fun emailValidation(email: String) = Pattern.compile(EMAIL_PATTERN).matcher(email).matches()