package com.jvg.sample2.app.data

import com.jvg.kmpblueprint.app.data.SharedAppRepository
import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.sample2.database.Sample2DB
import kotlinx.coroutines.flow.Flow

interface AppRepository : SharedAppRepository {
    // App specific methods
}

class DefaultAppRepository(
    private val dbHelper: DbHelper<Sample2DB>,
) : AppRepository {
    override val session: Flow<RequestState<Session>> = startFlow {
        val session: Session = dbHelper.withDatabase {
            executeOne(db.sessionQueries.findSession(mapper = Session::mapToSession))
        } ?: return@startFlow emit(
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
        dbHelper.withDatabase {
            db.sessionQueries.deleteSession()
        }
    }
}
