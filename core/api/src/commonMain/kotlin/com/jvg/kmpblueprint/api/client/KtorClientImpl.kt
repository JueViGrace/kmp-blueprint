package com.jvg.kmpblueprint.api.client

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

// Concrete implementation of KtorClient interface
expect class KtorClientImpl(
    baseUrl: String,
    coroutineContext: CoroutineContext,
    scope: CoroutineScope
) : KtorClient {
    override val baseUrl: String
    override val coroutineContext: CoroutineContext
    override val scope: CoroutineScope

    override fun client(baseUrl: String?): HttpClient
}
