package com.binance.api.client.service

import com.binance.api.client.domain.BinanceApiError
import com.binance.api.client.exception.BinanceApiException
import com.binance.api.client.security.AuthenticationInterceptor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.apache.commons.lang3.StringUtils
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Generates a Binance API implementation based on @see [BinanceApiServiceSpot].
 */
object BinanceApiServiceGenerator {
    /**
     * Returns the shared OkHttpClient instance.
     */
    val sharedClient: OkHttpClient = OkHttpClient.Builder()
//            .pingInterval(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
    private val converterFactory: Converter.Factory =
        JacksonConverterFactory.create(ObjectMapper().registerKotlinModule())
    private val errorBodyConverter = converterFactory.responseBodyConverter(
        BinanceApiError::class.java,
        arrayOfNulls(0),
        null
    ) as Converter<ResponseBody, BinanceApiError>

    fun <S> createService(serviceClass: Class<S>, apiKey: String?, secret: String?, baseUrl: String): S {
        val retrofitBuilder =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory)
        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient)
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            val adaptedClient = AuthenticationInterceptor(apiKey, secret).let {
                sharedClient.newBuilder().addInterceptor(it).build()
            }
            retrofitBuilder.client(adaptedClient)
        }
        return retrofitBuilder.build().create(serviceClass)
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    fun <T> executeSync(call: Call<T>): Response<T> {
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                return response
            } else {
                throw BinanceApiException(errorBodyConverter.convert(response.errorBody()!!)!!, call.request())
            }
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }

}