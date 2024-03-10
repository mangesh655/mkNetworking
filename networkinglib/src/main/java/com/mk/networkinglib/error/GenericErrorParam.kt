package com.mk.networkinglib.error

data class GenericErrorParam(
    val httpStatusCode: Int,
    val errorCode: String,
    val detail: String,
    val displayJson: String? = null,
    val invalidParams: List<InvalidRequestParam>? = null
)