package com.binance.api.client.exception

import com.binance.api.client.domain.rest.BinanceApiError
import okhttp3.Request
import retrofit2.Response

class BinanceApiException(
    val request: Request,
    val response: Response<*>,
    val apiError: BinanceApiError
) : RuntimeException() {

    override val message: String
        get() = "Http code: ${response.code()}. Api error code: ${apiError.code}. Api error message: \"${apiError.msg}\""
}