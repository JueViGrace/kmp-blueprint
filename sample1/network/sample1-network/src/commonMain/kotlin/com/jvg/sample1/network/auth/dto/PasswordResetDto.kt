package com.jvg.sample1.network.auth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PasswordResetDto(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
    @SerialName("new_password")
    val newPassword: String,
)
