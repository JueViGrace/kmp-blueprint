package com.jvg.sample1.types.auth

import com.jvg.sample1.network.auth.dto.LogInDto

data class LogIn(
    val username: String,
    val password: String,
) {
    fun toDto(): LogInDto {
        return LogInDto(
            username = username,
            password = password
        )
    }
}
