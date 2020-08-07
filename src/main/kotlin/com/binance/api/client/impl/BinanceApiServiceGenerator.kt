package com.binance.api.client.impl

import com.binance.api.client.BinanceApiError
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.exception.BinanceApiException
import com.binance.api.client.security.AuthenticationInterceptor
import okhttp3.Dispatcher
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
 * Generates a Binance API implementation based on @see [BinanceApiService].
 */
object BinanceApiServiceGenerator {
    /**
     * Returns the shared OkHttpClient instance.
     */
    var sharedClient = OkHttpClient.Builder()
            .pingInterval(20, TimeUnit.SECONDS)
            .apply {
                val dispatcher = Dispatcher().apply {
                    maxRequestsPerHost = 500
                    maxRequests = 500
                }
                dispatcher(dispatcher)
            }
            .build()!!
    private val converterFactory: Converter.Factory = JacksonConverterFactory.create()
    private val errorBodyConverter = converterFactory.responseBodyConverter(
            BinanceApiError::class.java, arrayOfNulls(0), null) as Converter<ResponseBody?, BinanceApiError>

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null, null)
    }

    fun <S> createService(serviceClass: Class<S>, apiKey: String?, secret: String?): S {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BinanceApiConstants.API_BASE_URL)
                .addConverterFactory(converterFactory)
        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient)
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            val interceptor = AuthenticationInterceptor(apiKey, secret)
            val adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build()
            retrofitBuilder.client(adaptedClient)
        }
        val retrofit = retrofitBuilder.build()
        return retrofit.create(serviceClass)
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    fun <T> executeSync(call: Call<T>): T {
        return try {
            val response = call.execute()
            if (response.isSuccessful) {
                response.body()!!
            } else {
                val apiError = getBinanceApiError(response)
                throw BinanceApiException(apiError)
            }
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    @Throws(IOException::class, BinanceApiException::class)
    fun getBinanceApiError(response: Response<*>): BinanceApiError {
        return errorBodyConverter.convert(response.errorBody()!!)
    }


}