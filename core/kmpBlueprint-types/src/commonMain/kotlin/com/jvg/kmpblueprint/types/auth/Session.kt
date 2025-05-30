package com.jvg.kmpblueprint.types.auth

/*
* Session object shared through all the projects.
* */
data class Session(
    val id: String,
    val accessToken: String,
    val refreshToken: String,
    val active: Boolean,
) {
    companion object {
        fun mapToSession(
            id: String,
            accessToken: String,
            refreshToken: String,
            active: Boolean,
        ): Session {
            return Session(
                id = id,
                accessToken = accessToken,
                refreshToken = refreshToken,
                active = active
            )
        }
    }
}
