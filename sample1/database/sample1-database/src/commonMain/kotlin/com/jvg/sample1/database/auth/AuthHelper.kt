package com.jvg.sample1.database.auth

import com.jvg.kmpblueprint.database.LocalDataSource
import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.sample1.database.Sample1DB
import kotlinx.coroutines.flow.firstOrNull
import migrations.S1_session

interface AuthHelper : LocalDataSource {
    override val dbHelper: DbHelper<Sample1DB>

    suspend fun getSession(): S1_session?
    suspend fun createSession(session: S1_session)
    suspend fun updateActive(active: Boolean, id: String)
    suspend fun deleteSession()
}

class DefaultAuthHelper(override val dbHelper: DbHelper<Sample1DB>) : AuthHelper {
    override suspend fun getSession(): S1_session? {
        return dbHelper.withDatabase {
            executeOneAsFlow(
                db.sessionQueries.findSession()
            )
        }?.firstOrNull()
    }

    override suspend fun createSession(session: S1_session) {
        dbHelper.withDatabase {
            db.transaction {
                db.sessionQueries.saveSession(session)
            }
        }
    }

    override suspend fun updateActive(active: Boolean, id: String) {
        dbHelper.withDatabase {
            db.transaction {
                db.sessionQueries.updateActive(
                    active = active,
                    id = id
                )
            }
        }
    }

    override suspend fun deleteSession() {
        dbHelper.withDatabase {
            db.sessionQueries.deleteSession()
        }
    }
}
