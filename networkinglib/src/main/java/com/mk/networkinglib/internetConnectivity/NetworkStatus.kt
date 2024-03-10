package com.mk.networkinglib.internetConnectivity

sealed interface NetworkStatus {
    data object Available : NetworkStatus

    data object Unavailable : NetworkStatus
}