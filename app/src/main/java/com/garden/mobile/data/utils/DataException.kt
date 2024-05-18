package com.garden.mobile.data.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

sealed class DataException : kotlin.Exception() {
    class GenericException(
        val code: Int = 0,
        val error: DataError.Errors,
    )
}

fun Throwable.parseException(): DataException.GenericException =
    when (this) {
        is UnknownHostException, is ConnectException, is SocketException ->
            DataException.GenericException(this.cause.hashCode(), DataError.Errors.RED_ERROR)

        is SocketTimeoutException, is TimeoutException ->
            DataException.GenericException(this.cause.hashCode(), DataError.Errors.TIMEOUT_ERROR)

        is HttpException, is IOException ->
            DataException.GenericException(this.cause.hashCode(), DataError.Errors.HTTP_ERROR)

        else ->
            DataException.GenericException(this.cause.hashCode(), DataError.Errors.GENERIC_ERROR)
    }
