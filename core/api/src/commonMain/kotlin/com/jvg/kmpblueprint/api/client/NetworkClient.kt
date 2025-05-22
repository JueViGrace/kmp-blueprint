package com.jvg.kmpblueprint.api.client

import com.jvg.kmpblueprint.api.ApiOperation
import com.jvg.kmpblueprint.api.NetworkRequestMethod
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

interface NetworkClient {
    val baseUrl: String

    // You can remove this properties if you don't need them
    val coroutineContext: CoroutineContext
    val scope: CoroutineScope

    suspend fun<T, R> call(
        method: NetworkRequestMethod,
        baseUrl: String?,
        urlString: String,
        body: T? = null,
        headers: Map<String, String>,
        contentType: String,
    ): ApiOperation<R>

    suspend fun<T> get(
        baseUrl: String? = null,
        urlString: String,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<T> {
        return call(
            method = NetworkRequestMethod.GET,
            baseUrl = baseUrl,
            urlString = urlString,
            body = null,
            headers = headers,
            contentType = contentType,
        )
    }
    suspend fun<T> post(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<T> {
        return call(
            method = NetworkRequestMethod.POST,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    suspend fun<T> put(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<T> {
        return call(
            method = NetworkRequestMethod.PUT,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    suspend fun<T> delete(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<T> {
        return call(
            method = NetworkRequestMethod.DELETE,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    suspend fun<T> patch(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<T> {
        return call(
            method = NetworkRequestMethod.PATCH,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    // todo: make head and options methods

    companion object {
        const val DEFAULT_CONTENT_TYPE = "application/json"
    }
}

