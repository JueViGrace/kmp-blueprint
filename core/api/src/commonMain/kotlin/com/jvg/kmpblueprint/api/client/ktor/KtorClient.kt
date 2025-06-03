package com.jvg.kmpblueprint.api.client.ktor

import com.jvg.kmpblueprint.api.client.base.NetworkClient
import com.jvg.kmpblueprint.api.model.ApiOperation
import com.jvg.kmpblueprint.api.model.ApiResponse
import com.jvg.kmpblueprint.api.model.NetworkRequestMethod
import com.jvg.kmpblueprint.api.model.getKtorHttpMethod
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

/*
* Default ktor client interface.
* */
interface KtorClient : NetworkClient {
    /*
     * todo:
     *     i think this creates a new client every time
     *     it could be good to have a property for this
     *     instead of creating a new client every time
     */
    /*
     *  Creates http client.
     *  @param baseUrl Base url for the request.
     * */
    fun client(baseUrl: String? = null): HttpClient

    /*
     * Implementation of call.
     * @param method Network request method.
     * @param baseUrl Base url for the request.
     * @param urlString Complete path for the request, should not contain prefixes if there is already one created.
     * @param body Request body.
     * @param headers Request headers.
     * @param contentType Request content type.
     * */
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
            ApiOperation.Failure(e)
        }
    }

    companion object {
        /*
         * Timeout for the requests.
         * */
        const val TIMEOUT = 30000L

        /*
         * Extension function to set the URL for this client
         * */
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
