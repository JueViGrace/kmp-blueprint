package com.jvg.sample1.auth.data

import com.jvg.kmpblueprint.auth.data.SharedAuthRepository
import com.jvg.kmpblueprint.network.model.ApiOperation
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.sample1.database.auth.AuthHelper
import com.jvg.sample1.network.auth.AuthClient
import com.jvg.sample1.network.auth.dto.ConfirmPasswordResetDto
import com.jvg.sample1.network.auth.dto.RequestPasswordResetDto
import com.jvg.sample1.types.auth.LogIn
import com.jvg.sample1.types.auth.PasswordReset
import com.jvg.sample1.types.auth.SignUpForm
import com.jvg.sample1.types.auth.mappers.toDbSession
import com.jvg.sample1.types.auth.mappers.toSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface AuthRepository : SharedAuthRepository {
    fun confirmPasswordReset(code: String): Flow<RequestState<Boolean>>
    fun login(logIn: LogIn): Flow<RequestState<Boolean>>
    fun requestPasswordReset(username: String): Flow<RequestState<Boolean>>
    fun resetPassword(reset: PasswordReset): Flow<RequestState<Boolean>>
    fun signUp(signUpForm: SignUpForm): Flow<RequestState<Boolean>>
}

class DefaultAuthRepository(
    override val authClient: AuthClient,
    private val authHelper: AuthHelper,
) : AuthRepository {
    override fun confirmPasswordReset(code: String): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                authClient.confirmPasswordReset(
                    ConfirmPasswordResetDto(
                        code = code
                    )
                )
            }
        ) { value ->
            emit(RequestState.Success(true))
        }
    }

    override fun login(logIn: LogIn): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                authClient.login(logIn.toDto())
            }
        ) { value ->
            scope.launch {
                updateSession(value.toSession().copy(active = true))
            }
            emit(RequestState.Success(true))
        }
    }

    override fun logout(): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                val session = authHelper.getSession()?.toSession()
                    ?: return@startNetworkRequest ApiOperation.Failure(Exception("Session not found"))
                authClient.logout(session.accessToken)
            }
        ) { value ->
            emit(RequestState.Success(true))
        }
    }

    override fun requestPasswordReset(username: String): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                authClient.requestPasswordReset(
                    RequestPasswordResetDto(
                        username = username
                    )
                )
            }
        ) { value ->
            emit(RequestState.Success(true))
        }
    }

    override fun resetPassword(reset: PasswordReset): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                authClient.resetPassword(reset.toDto())
            }
        ) { value ->
            emit(RequestState.Success(true))
        }
    }

    override fun signUp(signUpForm: SignUpForm): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                authClient.signUp(signUpForm.toDto())
            }
        ) { value ->
            scope.launch {
                updateSession(value.toSession().copy(active = true))
            }
            emit(RequestState.Success(true))
        }
    }

    override fun refresh(): Flow<RequestState<Boolean>> {
        return startNetworkRequest(
            call = {
                val session = authHelper.getSession()?.toSession()
                    ?: return@startNetworkRequest ApiOperation.Failure(Exception("Session not found"))
                authClient.refresh(session.refreshToken)
            }
        ) { value ->
            scope.launch {
                updateSession(value.toSession().copy(active = true))
            }
            emit(RequestState.Success(true))
        }
    }

    private suspend fun updateSession(session: Session) {
        authHelper.createSession(session.toDbSession())
    }
}
