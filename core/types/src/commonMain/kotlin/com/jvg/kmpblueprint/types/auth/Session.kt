package com.jvg.kmpblueprint.types.auth

/*
* Session object shared through all the projects.
* */
data class Session(
    val id: String,
    val accessToken: String,
    val refreshToken: String,
    val active: Boolean,
)
