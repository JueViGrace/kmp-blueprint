package com.jvg.kmpblueprint.network.client.ktor

import io.ktor.client.HttpClient

/*
* Ktor client expected implementation.
* */
expect class KtorClientImpl(
    baseUrl: String,
    prefix: String = "",
) : KtorClient {
    override val baseUrl: String
    override val prefix: String
    override fun client(baseUrl: String?): HttpClient
}
