package com.mk.networkinglib.util

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Singleton
import com.mk.networkinglib.error.GenericErrorParam
import com.mk.networkinglib.util.Result

/**
 * Wrap a suspending API [call] in try/catch. In case an exception is thrown, a [Result.Error] is
 * created based on the [errorMessage].
 */
@Singleton
class NetworkUtil {
    suspend fun <T : Any?> safeApiCall(
        call: suspend () -> Result<T?>,
        errorMessage: String
    ): Result<T?> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            Result.Error(
                GenericErrorParam(
                    500,
                    "Internal Server Error",
                    "Exception --> ${e.message}  $errorMessage"
                )
            )
//        Result.UnhandledError(IOException(errorMessage, e))
        }
    }


    /**
     * @param response :
     */
    fun <T> getGenericErrorResponse(
        response: retrofit2.Response<T>,
        gson: Gson,
    ): GenericErrorParam? {
        val reader: BufferedReader?
        val sb = StringBuilder()
        try {
            reader = BufferedReader(InputStreamReader(response.errorBody()!!.byteStream()))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    sb.append(line)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val str = sb.toString()
        val genericErrorHandler = gson.fromJson(str, GenericErrorParam::class.java)
        return genericErrorHandler;
    }
}