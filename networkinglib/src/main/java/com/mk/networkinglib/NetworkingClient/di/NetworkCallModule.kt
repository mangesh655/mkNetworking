package com.mk.networkinglib.NetworkingClient.di

import com.mk.networkinglib.NetworkingClient.INetworkCall
import com.mk.networkinglib.NetworkingClient.INetworkSetup
import com.mk.networkinglib.NetworkingClient.NetworkCall
import com.mk.networkinglib.NetworkingClient.NetworkSetup
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

    @Binds
    @Singleton
    fun provideNetworkSetup(
        networkSetup: NetworkSetup
    ): INetworkSetup

}
