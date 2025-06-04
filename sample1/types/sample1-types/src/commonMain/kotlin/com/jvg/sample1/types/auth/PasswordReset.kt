package com.jvg.sample1.types.auth

import com.jvg.sample1.network.auth.dto.PasswordResetDto

data class PasswordReset(
    val username: String,
    val password: String,
    val newPassword: String,
) {
    fun toDto(): PasswordResetDto {
        return PasswordResetDto(
            username = username,
            password = password,
            newPassword = newPassword
        )
    }
}
