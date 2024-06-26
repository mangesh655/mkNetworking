package com.mk.networkinglib.Interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApikeyInterceptor(
    private val apiKey: String
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newHttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newHttpUrl)
            .build()
        return chain.proceed(newRequest)
    }
}