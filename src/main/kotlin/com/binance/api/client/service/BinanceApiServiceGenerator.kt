package com.binance.api.client.service

import com.binance.api.client.domain.rest.BinanceApiError
import com.binance.api.client.security.AuthenticationInterceptor
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.apache.commons.lang3.StringUtils
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
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
        val response = call.execute()
        if (response.isSuccessful) {
            return response
        } else {
            try {
                val apiError = errorBodyConverter.convert(response.errorBody()!!)!!
                throw BinanceApiException(call.request(), response, apiError)
            } catch (e: JsonParseException) {
                throw BinanceApiDecodeErrorException(call.request(), response)
            }
        }
    }

    class BinanceApiDecodeErrorException(val request: Request, val response: Response<*>) : RuntimeException()

    class BinanceApiException(
        val request: Request,
        val response: Response<*>,
        val apiError: BinanceApiError
    ) : RuntimeException() {

        override val message: String
            get() = "Http code: ${response.code()}. Api error code: ${apiError.code}. Api error message: \"${apiError.msg}\""
    }
}