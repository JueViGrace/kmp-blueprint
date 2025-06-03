package com.jvg.kmpblueprint.auth.data

import com.jvg.kmpblueprint.shared.data.Repository
import com.jvg.kmpblueprint.types.state.RequestState
import kotlinx.coroutines.flow.Flow

interface SharedAuthRepository : Repository {
    fun requestPasswordReset(username: String): Flow<RequestState<Boolean>>
    fun refresh(): Flow<RequestState<Boolean>>
}
