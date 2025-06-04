package com.jvg.sample1.types.auth.mappers

import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.sample1.network.auth.response.AuthResponse

fun AuthResponse.toSession(): Session {
    return Session(
        id = id,
        accessToken = accessToken,
        refreshToken = refreshToken,
        active = false
    )
}
