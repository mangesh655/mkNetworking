package com.mk.networkinglib.NetworkingClient

import com.google.gson.Gson
import javax.inject.Inject
import com.mk.networkinglib.util.NetworkUtil
import com.mk.networkinglib.util.Result

class NetworkCall @Inject constructor(
    private val networkApiService: NetworkApiService,
    private val networkUtil: NetworkUtil,
    private val gson: Gson
) : INetworkCall {

    override suspend fun <T> getData(path: String, queries: Map<String, Any>): Result<T?> {
        return networkUtil.safeApiCall({ getDataAsync(path, queries) }, "");
    }

    private suspend fun <T> getDataAsync(path: String, queries: Map<String, Any>): Result<T?> {

        var response = networkApiService.getData<T>(path, queries);
        if (response.isSuccessful) {
            return Result.Success(response.body());
        }

        return Result.Error(networkUtil.getGenericErrorResponse(response, gson))
    }

    override suspend fun <T> postData(path: String, body: Any): Result<T?> {
        return networkUtil.safeApiCall({ postDataAsync(path, body) }, "");
    }

    suspend fun <T> postDataAsync(path: String, body: Any): Result<T?> {
        var response = networkApiService.postData<T>(path, body);
        if (response.isSuccessful) {
            return Result.Success(response.body());
        }

        return Result.Error(networkUtil.getGenericErrorResponse(response, gson))
    }
}