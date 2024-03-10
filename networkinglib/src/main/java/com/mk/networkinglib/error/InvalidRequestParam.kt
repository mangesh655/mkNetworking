package com.mk.networkinglib.error

data class InvalidRequestParam(
    val errorCode: String,
    val field: String,
    val reason: String,
    val location: String,
    val detail: String,
    val displayJson: String,
    val extraInfoUrl: String
)