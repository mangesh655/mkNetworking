package com.mk.networkinglib.NetworkingClient.di

import com.mk.networkinglib.NetworkingClient.INetworkCall
import com.mk.networkinglib.NetworkingClient.NetworkCall
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface NetworkCallModule {

    @Binds
    @Singleton
    fun provideNetworkCall(
        networkCall: NetworkCall
    ): INetworkCall

}
