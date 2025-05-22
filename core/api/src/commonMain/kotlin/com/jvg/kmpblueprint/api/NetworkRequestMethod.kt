package com.jvg.kmpblueprint.api

import io.ktor.http.HttpMethod

enum class NetworkRequestMethod {
    GET,
    POST,
    PUT,
    DELETE,
    PATCH,
    HEAD,
    OPTIONS,
}

fun getKtorHttpMethod(method: NetworkRequestMethod): HttpMethod {
    return when (method) {
        NetworkRequestMethod.GET -> HttpMethod.Get
        NetworkRequestMethod.POST -> HttpMethod.Post
        NetworkRequestMethod.PUT -> HttpMethod.Put
        NetworkRequestMethod.DELETE -> HttpMethod.Delete
        NetworkRequestMethod.PATCH -> HttpMethod.Patch
        NetworkRequestMethod.HEAD -> HttpMethod.Head
        NetworkRequestMethod.OPTIONS -> HttpMethod.Options
    }
}
