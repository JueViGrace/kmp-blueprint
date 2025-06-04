package com.jvg.sample1.network.auth

import com.jvg.kmpblueprint.network.auth.SharedAuthClient
import com.jvg.kmpblueprint.network.client.base.NetworkClient
import com.jvg.kmpblueprint.network.model.ApiOperation
import com.jvg.sample1.network.auth.dto.ConfirmPasswordResetDto
import com.jvg.sample1.network.auth.dto.LogInDto
import com.jvg.sample1.network.auth.dto.PasswordResetDto
import com.jvg.sample1.network.auth.dto.RequestPasswordResetDto
import com.jvg.sample1.network.auth.dto.SignUpDto
import com.jvg.sample1.network.auth.response.AuthResponse

interface AuthClient : SharedAuthClient {
    suspend fun confirmPasswordReset(dto: ConfirmPasswordResetDto): ApiOperation<String>
    suspend fun login(dto: LogInDto): ApiOperation<AuthResponse>
    suspend fun logout(token: String): ApiOperation<String>
    suspend fun refresh(token: String): ApiOperation<AuthResponse>
    suspend fun requestPasswordReset(dto: RequestPasswordResetDto): ApiOperation<String>
    suspend fun resetPassword(dto: PasswordResetDto): ApiOperation<String>
    suspend fun signUp(dto: SignUpDto): ApiOperation<AuthResponse>
}

class DefaultAuthClient(override val client: NetworkClient) : AuthClient {
    override suspend fun confirmPasswordReset(dto: ConfirmPasswordResetDto): ApiOperation<String> {
        return client.post(
            urlString = "/auth/forgot/confirm",
            body = dto,
        )
    }

    override suspend fun login(dto: LogInDto): ApiOperation<AuthResponse> {
        return client.post(
            urlString = "/auth/login",
            body = dto,
        )
    }

    override suspend fun logout(token: String): ApiOperation<String> {
        return client.post(
            urlString = "/auth/logout",
            body = null,
            headers = mapOf("Authorization" to "Bearer $token"),
        )
    }

    override suspend fun refresh(token: String): ApiOperation<AuthResponse> {
        return client.get(
            urlString = "/auth/refresh",
            headers = mapOf("Authorization" to "Bearer $token"),
        )
    }

    override suspend fun requestPasswordReset(dto: RequestPasswordResetDto): ApiOperation<String> {
        return client.post(
            urlString = "/auth/forgot/request",
            body = dto,
        )
    }

    override suspend fun resetPassword(dto: PasswordResetDto): ApiOperation<String> {
        return client.post(
            urlString = "/auth/forgot/reset",
            body = dto,
        )
    }

    override suspend fun signUp(dto: SignUpDto): ApiOperation<AuthResponse> {
        return client.post(
            urlString = "/auth/signin",
            body = dto,
        )
    }
}
