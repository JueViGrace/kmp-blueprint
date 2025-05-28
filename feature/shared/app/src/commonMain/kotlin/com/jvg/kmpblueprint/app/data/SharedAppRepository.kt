package com.jvg.kmpblueprint.app.data

import com.jvg.kmpblueprint.shared.data.Repository
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import kotlinx.coroutines.flow.Flow

interface SharedAppRepository : Repository {
    val session: Flow<RequestState<Session>>

    suspend fun endSession()
}
