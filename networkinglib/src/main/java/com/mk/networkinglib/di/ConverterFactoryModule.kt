package com.mk.networkinglib.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import javax.inject.Singleton
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object ConverterFactoryModule {

    @Provides
    @Singleton
    fun provideSerializationConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val format = Json { ignoreUnknownKeys = true }
        return format.asConverterFactory(contentType)
    }
}