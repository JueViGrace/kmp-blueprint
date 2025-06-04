package com.jvg.sample1.network.auth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPasswordResetDto(
    @SerialName("username")
    val username: String,
)
