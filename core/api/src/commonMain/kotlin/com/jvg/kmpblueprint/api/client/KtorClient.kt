package com.jvg.kmpblueprint.api.client

import com.jvg.kmpblueprint.api.ApiOperation
import com.jvg.kmpblueprint.api.ApiResponse
import com.jvg.kmpblueprint.api.NetworkRequestMethod
import com.jvg.kmpblueprint.api.getKtorHttpMethod
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.URLBuilder
import io.ktor.http.contentType
import io.ktor.http.path
import kotlinx.coroutines.ensureActive

// Default interface for a network client using Ktor
interface KtorClient : NetworkClient {
    // Client function that accepts a base url and returns a Ktor HttpClient
    fun client(baseUrl: String? = null): HttpClient

    // Default implementation to make network requests for this client
    override suspend fun <T, R> call(
        method: NetworkRequestMethod,
        baseUrl: String?,
        urlString: String,
        body: T?,
        headers: Map<String, String>,
        contentType: String
    ): ApiOperation<R> {
        return try {
            val response: HttpResponse = client(baseUrl).request {
                this.method = getKtorHttpMethod(method)
                url {
                    setUrl(urlString = urlString)
                }
                contentType(ContentType.parse(contentType))
                headers.forEach { (key, value) ->
                    headers {
                        append(key, value)
                    }
                }
                if (body != null) {
                    setBody(body)
                }
            }
            val body: ApiResponse<R> = response.body()
            ApiOperation.Success(body)
        } catch (e: Exception) {
            coroutineContext.ensureActive()
            ApiOperation.Error(e)
        }
    }

    companion object {
        const val TIMEOUT = 30000L

        // Extension function to set the URL for this client
        fun URLBuilder.setUrl(urlString: String) {
            if (urlString.contains("?")) {
                val path: List<String> = urlString.split("?")

                path(path[0])
                var pair: List<String>
                if (path[1].contains("&")) {
                    path[1].split("&").forEach { parameter ->
                        pair = parameter.split("=")
                        parameters.append(pair[0], pair[1])
                    }
                } else {
                    pair = path[1].split("=")
                    parameters.append(pair[0], pair[1])
                }
            } else {
                path(urlString)
            }
        }
    }
}
