package com.jvg.kmpblueprint.shared.data

import com.jvg.kmpblueprint.api.ApiOperation
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.kmpblueprint.util.Logs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

interface Repository {
    val coroutineContext: CoroutineContext
        get() = Dispatchers.Default
    val scope: CoroutineScope
        get() = CoroutineScope(coroutineContext + SupervisorJob())

    fun <T> startFlow(
        block: suspend FlowCollector<RequestState<T>>.() -> Unit
    ): Flow<RequestState<T>> {
        return flow {
            emit(RequestState.Loading)
            try {
                block()
            } catch (e: Exception) {
                Logs.error(tag = this::class.simpleName ?: "Repository", msg = "Start flow error:", tr = e)
                emit(
                    RequestState.Error(
                        error = e,
                    ),
                )
            }
        }.flowOn(coroutineContext)
    }

    fun <T, R> startNetworkRequest(
        call: suspend () -> ApiOperation<T>,
        block: suspend FlowCollector<RequestState<R>>.(data: T) -> Unit,
    ): Flow<RequestState<R>> {
        return startFlow {
            checkNetworkResponse(
                call = call(),
                onError = { error ->
                    emit(error)
                },
                onSuccess = { data ->
                    block(data)
                }
            )
        }
    }

    suspend fun <T> checkNetworkResponse(
        call: ApiOperation<T>,
        onError: suspend (error: RequestState.Error) -> Unit,
        onSuccess: suspend (data: T) -> Unit,
    ) {
        when (call) {
            is ApiOperation.Failure -> {
                onError(
                    RequestState.Error(
                        error = call.exception
                    )
                )
            }

            is ApiOperation.Success -> {
                val data: T = call.value.data
                    ?: return onError(
                        RequestState.Error(
                            error = Exception("Data is null")
                        )
                    )
                onSuccess(data)
            }
        }
    }
}