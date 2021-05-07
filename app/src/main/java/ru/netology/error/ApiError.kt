package ru.netology.error

import com.google.android.gms.common.api.ApiException
import java.net.ConnectException

sealed class ApiError : RuntimeException() {
    object ServerError : ApiError()
    object NetworkError : ApiError()
    object UnknownError : ApiError()

    companion object {
        fun fromThrowable(throwable: Throwable): ApiError =
                when (throwable) {
                    is ApiException -> ServerError
                    is ConnectException -> NetworkError
                    else -> UnknownError
                }
    }
}
