package com.mk.networkinglib.NetworkingClient

import com.mk.networkinglib.util.Result

interface INetworkCall {

    suspend fun <T> getData(
        path: String,
        queries: @JvmSuppressWildcards Map<String, Any>
    ): Result<T?>


    suspend fun <T> postData(
        path: String,
        body: Any
    ): Result<T?>

}