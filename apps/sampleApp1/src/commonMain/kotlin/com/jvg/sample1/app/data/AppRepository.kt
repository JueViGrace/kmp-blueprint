package com.jvg.sample1.app.data

import com.jvg.kmpblueprint.app.data.SharedAppRepository
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.sample1.database.auth.AuthHelper
import com.jvg.sample1.types.auth.mappers.toSession
import kotlinx.coroutines.flow.Flow

interface AppRepository : SharedAppRepository {
    // App specific methods
}

class DefaultAppRepository(
    private val authHelper: AuthHelper,
) : AppRepository {
    override val session: Flow<RequestState<Session>> = startFlow {
        val session: Session = authHelper.getSession()?.toSession()
            ?: return@startFlow emit(
                RequestState.Error(
                    error = "Session not found"
                )
            )

        emit(
            RequestState.Success(
                data = session
            )
        )
    }

    override suspend fun endSession() {
        authHelper.deleteSession()
    }
}
