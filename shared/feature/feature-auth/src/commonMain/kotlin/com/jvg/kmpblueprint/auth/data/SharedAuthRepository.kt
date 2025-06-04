package com.jvg.kmpblueprint.auth.data

import com.jvg.kmpblueprint.network.auth.SharedAuthClient
import com.jvg.kmpblueprint.shared.data.Repository
import com.jvg.kmpblueprint.types.state.RequestState
import kotlinx.coroutines.flow.Flow

interface SharedAuthRepository : Repository {
    val authClient: SharedAuthClient

    fun logout(): Flow<RequestState<Boolean>>
    fun refresh(): Flow<RequestState<Boolean>>
}
