package com.jvg.kmpblueprint.network.client.base

import com.jvg.kmpblueprint.network.model.ApiOperation
import com.jvg.kmpblueprint.network.model.NetworkRequestMethod
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

/*
* Default network client interface.
* */
interface NetworkClient {
    val baseUrl: String

    // You can remove this properties if you don't need them
    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
    val scope: CoroutineScope
        get() = CoroutineScope(coroutineContext + SupervisorJob())

    /*
     * Makes a network request.
     * @param method Network request method.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request, should not contain prefixes if there is already one created.
     * @param body Request body.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T, R> call(
        method: NetworkRequestMethod,
        baseUrl: String?,
        urlString: String,
        body: T? = null,
        headers: Map<String, String>,
        contentType: String,
    ): ApiOperation<R>

    /*
     * Makes a GET request.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T> get(
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

    /*
     * Makes a POST request.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T, R> post(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<R> {
        return call(
            method = NetworkRequestMethod.POST,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    /*
     * Makes a PUT request.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T, R> put(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<R> {
        return call(
            method = NetworkRequestMethod.PUT,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    /*
     * Makes a DELETE request.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T, R> delete(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<R> {
        return call(
            method = NetworkRequestMethod.DELETE,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    /*
     * Makes a PATCH request.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
    suspend fun <T, R> patch(
        baseUrl: String? = null,
        urlString: String,
        body: T? = null,
        headers: Map<String, String> = emptyMap(),
        contentType: String = DEFAULT_CONTENT_TYPE,
    ): ApiOperation<R> {
        return call(
            method = NetworkRequestMethod.PATCH,
            baseUrl = baseUrl,
            urlString = urlString,
            body = body,
            headers = headers,
            contentType = contentType,
        )
    }

    companion object {
        /*
         * @property DEFAULT_CONTENT_TYPE Default content type for the request.
         * */
        const val DEFAULT_CONTENT_TYPE = "application/json"
    }
}
