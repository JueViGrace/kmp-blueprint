package com.jvg.sample1.types.auth.mappers

import com.jvg.kmpblueprint.types.auth.Session
import migrations.S1_session

fun Session.toDbSession(): S1_session {
    return S1_session(
        id = id,
        access_token = accessToken,
        refresh_token = refreshToken,
        active = active
    )
}
