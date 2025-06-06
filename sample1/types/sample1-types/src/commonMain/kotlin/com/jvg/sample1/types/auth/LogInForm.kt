package com.jvg.sample1.types.auth

import com.jvg.sample1.network.auth.dto.LogInDto

data class LogInForm(
    val username: String = "",
    val password: String = "",
    val shouldShowUsernameError: Boolean = false,
    val shouldShowPasswordError: Boolean = false,
) {
    fun toDto(): LogInDto {
        return LogInDto(
            username = username,
            password = password
        )
    }
}
