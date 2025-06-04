package com.jvg.kmpblueprint.shared.data

import com.jvg.kmpblueprint.network.model.ApiOperation
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

/*
* Standard repository.
* */
interface Repository {
    /*
     * @property coroutineContext Context used for the coroutines launched in repositories.
     * */
    val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    /*
     * @property scope Scope to launch coroutines in repositories.
     * */
    val scope: CoroutineScope
        get() = CoroutineScope(coroutineContext + SupervisorJob())

    /*
     * Starts a flow and returns a RequestState<T> with the provided type.
     * @param block Block that delegates the actual job for this flow to the caller.
     * */
    fun <T> startFlow(
        block: suspend FlowCollector<RequestState<T>>.() -> Unit
    ): Flow<RequestState<T>> {
        return flow {
            emit(RequestState.Loading)
            try {
                block()
            } catch (e: Exception) {
                Logs.error(
                    tag = this::class.simpleName ?: "Repository",
                    msg = "Start flow error:",
                    tr = e
                )
                emit(
                    RequestState.Error(
                        error = e,
                    ),
                )
            }
        }.flowOn(coroutineContext)
    }

    /*
     * Starts a flow and then executes a network request and returns a RequestState<R> with the provided type.
     * @param call Network request to execute.
     * @param block Block that delegates the actual job for this flow to the caller.
     * */
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

    /*
     * Checks the state of the network request and returns a RequestState<T> with the provided type.
     * @param call Value to check.
     * @param onError Block that returns the error of the call to the caller.
     * @param onSuccess Block that returns the response to the caller.
     * */
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
