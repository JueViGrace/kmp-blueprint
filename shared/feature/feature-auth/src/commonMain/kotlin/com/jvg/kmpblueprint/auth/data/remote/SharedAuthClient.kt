package com.jvg.kmpblueprint.auth.data.remote

import com.jvg.kmpblueprint.api.client.base.NetworkClient
import com.jvg.kmpblueprint.api.model.ApiOperation

interface SharedAuthClient {
    val client: NetworkClient

    suspend fun requestPasswordReset(email: String, token: String): ApiOperation<Boolean> {
        return client.post(
            urlString = "/auth/forgot/request",
            body = mapOf("email" to email),
            headers = mapOf("Authorization" to "Bearer $token"),
        )
    }

    /*suspend fun resetPassword(dto: ResetPasswordDto, token: String): ApiOperation<Boolean> {
        return client.post(
            urlString = "/auth/forgot/reset",
            body = mapOf("email" to email, "password" to password),
            headers = mapOf("Authorization" to "Bearer $token"),
        )
    }*/

    suspend fun refresh(token: String): ApiOperation<Boolean> {
        return client.get(
            urlString = "/auth/refresh",
            headers = mapOf("Authorization" to "Bearer $token"),
        )
    }
}
