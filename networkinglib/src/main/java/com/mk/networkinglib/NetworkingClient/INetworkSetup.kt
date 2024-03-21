package com.mk.networkinglib.NetworkingClient

interface INetworkSetup {

    fun setBaseUrl(url : String)
    fun getBaseUrl() : String
    fun setApiKey(apiKey : String)
    fun  getApiKey() : String
}