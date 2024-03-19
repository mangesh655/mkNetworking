package com.mk.networkinglib.di

import com.mk.networkinglib.Interceptor.ApikeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Named("base_url")
    fun getBaseUrl(): String {
        return ""
    }

    @Provides
    @Singleton
    fun provideApikeyInterceptor(): ApikeyInterceptor {
        return ApikeyInterceptor("")
    }
}
