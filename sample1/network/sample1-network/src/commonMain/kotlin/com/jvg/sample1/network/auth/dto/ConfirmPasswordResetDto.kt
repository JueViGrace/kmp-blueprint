package com.jvg.sample1.network.auth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfirmPasswordResetDto(
    @SerialName("code")
    val code: String,
)
