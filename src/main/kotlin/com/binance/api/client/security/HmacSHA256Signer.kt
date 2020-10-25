package com.binance.api.client.security

import org.apache.commons.codec.binary.Hex
import java.net.URLEncoder
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
class HmacSHA256Signer {
    companion object {
        /**
         * Sign the given message using the given secret.
         * @param message message to sign
         * @param secret secret key
         * @return a signed message
         */
        fun sign(message: String?, secret: String?): String {
            return try {
                val sha256_HMAC = Mac.getInstance("HmacSHA256")
                val secretKeySpec = SecretKeySpec(secret!!.toByteArray(), "HmacSHA256")
                sha256_HMAC.init(secretKeySpec)
                String(Hex.encodeHex(sha256_HMAC.doFinal(URLEncoder.encode(message!!, "UTF-8").toByteArray())))
            } catch (e: Exception) {
                throw RuntimeException("Unable to sign message.", e)
            }
        }
    }
}