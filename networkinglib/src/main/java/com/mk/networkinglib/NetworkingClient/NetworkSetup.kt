package com.mk.networkinglib.NetworkingClient

import javax.inject.Inject

class NetworkSetup @Inject constructor() : INetworkSetup {

    private lateinit var baseUrl : String
    private lateinit var apiKey : String

    override fun setBaseUrl(url: String) {
        this.baseUrl = url
    }

    override fun getBaseUrl(): String {
        return baseUrl
    }

    override fun setApiKey(apiKey: String) {
        this.apiKey = apiKey
    }

    override fun getApiKey(): String {
        return apiKey
    }
}