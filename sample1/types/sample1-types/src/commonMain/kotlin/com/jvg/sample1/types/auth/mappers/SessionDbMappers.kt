package com.jvg.sample1.types.auth.mappers

import com.jvg.kmpblueprint.types.auth.Session
import migrations.S1_session

fun S1_session.toSession(): Session {
    return Session(
        id = id,
        accessToken = access_token,
        refreshToken = refresh_token,
        active = active
    )
}
