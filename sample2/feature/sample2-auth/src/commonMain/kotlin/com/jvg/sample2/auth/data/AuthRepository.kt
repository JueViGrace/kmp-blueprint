package com.jvg.sample2.auth.data

import com.jvg.kmpblueprint.auth.data.SharedAuthRepository
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.sample2.network.auth.AuthClient
import kotlinx.coroutines.flow.Flow

interface AuthRepository : SharedAuthRepository

class DefaultAuthRepository(override val authClient: AuthClient) : AuthRepository {
    override fun refresh(): Flow<RequestState<Boolean>> {
        return startFlow { }
    }

    override fun logout(): Flow<RequestState<Boolean>> {
        return startFlow { }
    }
}
