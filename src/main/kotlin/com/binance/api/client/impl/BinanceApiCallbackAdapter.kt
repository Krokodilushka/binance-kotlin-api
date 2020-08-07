package com.binance.api.client.impl

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.exception.BinanceApiException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a BinanceApiCallback which is exposed to the client.
 */
class BinanceApiCallbackAdapter<T>(private val callback: BinanceApiCallback<T>) : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            callback.onResponse(response.body()!!)
        } else {
            if (response.code() == 504) {
                // HTTP 504 return code is used when the API successfully sent the message but not get a response within the timeout period.
                // It is important to NOT treat this as a failure; the execution status is UNKNOWN and could have been a success.
                return
            }
            try {
                val apiError = BinanceApiServiceGenerator.getBinanceApiError(response)
                onFailure(call, BinanceApiException(apiError))
            } catch (e: IOException) {
                onFailure(call, BinanceApiException(e))
            }
        }
    }

    override fun onFailure(call: Call<T>, throwable: Throwable) {
        if (throwable is BinanceApiException) {
            callback.onFailure(throwable)
        } else {
            callback.onFailure(BinanceApiException(throwable))
        }
    }

}