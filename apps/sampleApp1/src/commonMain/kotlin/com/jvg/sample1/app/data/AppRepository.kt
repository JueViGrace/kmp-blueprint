package com.jvg.sample1.app.data

import com.jvg.kmpblueprint.api.client.NetworkClient
import com.jvg.kmpblueprint.app.data.SharedAppRepository
import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.sample1.database.Sample1DB
import kotlinx.coroutines.flow.Flow

interface AppRepository : SharedAppRepository {
    // App specific methods
}

class DefaultAppRepository(
    override val dbHelper: DbHelper<Sample1DB>,
    override val client: NetworkClient
) : AppRepository {
    override val session: Flow<RequestState<Session>> = startFlow {
        val session: Session = dbHelper.withDatabase {
            executeOne(db.sessionQueries.findSession(mapper = Session::mapToSession))
        } ?: return@startFlow emit(
            RequestState.Error(
                error = Exception("Session not found")
            )
        )

        emit(
            RequestState.Success(
                data = session
            )
        )
    }

    override suspend fun endSession() {
        dbHelper.withDatabase {
            db.sessionQueries.deleteSession()
        }
    }
}
