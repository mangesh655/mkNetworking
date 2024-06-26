package com.mk.networkinglib.di

import android.content.Context
import com.mk.networkinglib.Interceptor.ApikeyInterceptor
import com.mk.networkinglib.NetworkingClient.INetworkSetup
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
internal object RetrofitClientModule {

    @Provides
    @Singleton
    fun httpCache(
        @ApplicationContext context: Context
    ): Cache {
        return okhttp3.Cache(context.cacheDir, HTTP_CACHE_SIZE_BYTES.toLong())
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache,
        networkSetup : INetworkSetup
    ): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(ApikeyInterceptor(networkSetup.getApiKey()))
            callTimeout(CALL_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            retryOnConnectionFailure(true)
            followRedirects(true)
            followSslRedirects(true)
            cache(cache)
        }
        return builder.build()
    }

    const val HTTP_CACHE_SIZE_BYTES = 1024 * 1024 * 50
    const val CONNECT_TIMEOUT_MILLIS = 10_000L
    private const val READ_TIMEOUT_MILLIS = 10_000L
    private const val WRITE_TIMEOUT_MILLIS = 10_000L
    private const val CALL_TIMEOUT_MILLIS = 0L
}