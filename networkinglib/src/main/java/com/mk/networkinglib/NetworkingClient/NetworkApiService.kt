package com.mk.networkinglib.NetworkingClient

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface NetworkApiService {

    @GET("{path}")
    suspend fun <T> getData(
        @Path("path") path: String,
        @QueryMap queries: @JvmSuppressWildcards Map<String, Any>
    ): Response<T>

    @POST("{path}")
    suspend fun <T> postData(
        @Path("path") path: String,
        @Body requestBody: Any
    ): Response<T>

    //we can have similar such generic functions for PUT, PATCH, POST with header, etc...
    //For now, just having 2 functions for the sake of demo.
}
