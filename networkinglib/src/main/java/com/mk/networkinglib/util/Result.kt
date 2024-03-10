package com.mk.networkinglib.util

import com.mk.networkinglib.error.GenericErrorParam

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T : Any?> {

    data class Success<out T : Any?>(val data: T?) : Result<T?>()
    data class Error(val errorBody: GenericErrorParam?) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$errorBody]"
        }
    }
}
