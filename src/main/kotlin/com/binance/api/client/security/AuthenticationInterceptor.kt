package com.binance.api.client.security

import com.binance.api.client.BinanceApiConstants
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer
import org.apache.commons.lang3.StringUtils
import java.io.IOException
import java.util.*

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
class AuthenticationInterceptor(private val apiKey: String?, private val secret: String?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequestBuilder = original.newBuilder()
        val isApiKeyRequired = original.header(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY) != null
        val isSignatureRequired = original.header(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED) != null
        newRequestBuilder.removeHeader(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY)
            .removeHeader(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED)

        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired || isSignatureRequired) {
            require(null !== apiKey) {
                "apiKey required"
            }
            newRequestBuilder.addHeader(BinanceApiConstants.API_KEY_HEADER, apiKey!!)
        }

        // Endpoint requires signing the payload
        if (isSignatureRequired) {
            val payload = original.url().query()
            if (!StringUtils.isEmpty(payload)) {
                val sig = Signature().getSignature(payload!!, secret!!)
                val signedUrl = original.url().newBuilder().addQueryParameter("signature", sig).build()
                newRequestBuilder.url(signedUrl)
            }
        }

        // Build new request after adding the necessary authentication information
        val newRequest = newRequestBuilder.build()
        return chain.proceed(newRequest)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AuthenticationInterceptor
        return apiKey == that.apiKey &&
                secret == that.secret
    }

    override fun hashCode(): Int {
        return Objects.hash(apiKey, secret)
    }

    companion object {
        /**
         * Extracts the request body into a String.
         *
         * @return request body as a string
         */
        private fun bodyToString(request: RequestBody): String {
            try {
                Buffer().use { buffer ->
                    request.writeTo(buffer)
                    return buffer.readUtf8()
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }

}