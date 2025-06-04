package com.jvg.kmpblueprint.network.model

/*
* Represents a network request operation.
* */
sealed interface ApiOperation<out T> {
    data class Success<T>(val value: ApiResponse<T>) : ApiOperation<T>

    data class Failure(val exception: Exception) : ApiOperation<Nothing>
}
