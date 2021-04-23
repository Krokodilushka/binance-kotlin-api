package com.binance.api.client.security

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class Signature {
    val HMAC_SHA256 = "HmacSHA256"

    //convert byte array to hex string
    private fun bytesToHex(bytes: ByteArray?): String {
        val hexArray = "0123456789abcdef".toCharArray()
        val hexChars = CharArray(bytes!!.size * 2)
        var j = 0
        var v: Int
        while (j < bytes.size) {
            v = bytes[j].toInt() and 0xFF
            hexChars[j * 2] = hexArray[v ushr 4]
            hexChars[j * 2 + 1] = hexArray[v and 0x0F]
            j++
        }
        return String(hexChars)
    }

    fun getSignature(data: String, key: String): String {
        var hmacSha256: ByteArray? = null
        hmacSha256 = try {
            val secretKeySpec = SecretKeySpec(key.toByteArray(), HMAC_SHA256)
            val mac = Mac.getInstance(HMAC_SHA256)
            mac.init(secretKeySpec)
            mac.doFinal(data.toByteArray())
        } catch (e: Exception) {
            throw RuntimeException("Failed to calculate hmac-sha256", e)
        }
        return bytesToHex(hmacSha256)
    }
}