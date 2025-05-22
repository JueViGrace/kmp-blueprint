package com.jvg.kmpblueprint.api

// Sealed interface representing the result of an API operation
sealed interface ApiOperation<out T> {
    data class Success<T>(val data: ApiResponse<T>) : ApiOperation<T>

    // todo: create data class to catch errors in response, not only exceptions
    data class Error(val exception: Exception) : ApiOperation<Nothing>
}
