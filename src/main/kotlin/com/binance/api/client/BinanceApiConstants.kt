package com.binance.api.client

/**
 * Constants used throughout Binance's API.
 */
object BinanceApiConstants {
    /**
     * REST API base URL.
     */
    const val API_BASE_URL = "https://api.binance.com"

    /**
     * Streaming API base URL.
     */
    const val WS_API_BASE_URL = "wss://stream.binance.com:9443/stream?streams="

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    const val API_KEY_HEADER = "X-MBX-APIKEY"

    /**
     * Decorator to indicate that an endpoint requires an API key.
     */
    const val ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY"
    const val ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = "$ENDPOINT_SECURITY_TYPE_APIKEY: #"

    /**
     * Decorator to indicate that an endpoint requires a signature.
     */
    const val ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED"
    const val ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = "$ENDPOINT_SECURITY_TYPE_SIGNED: #"

    /**
     * Spot receiving window.
     */
    const val SPOT_RECEIVING_WINDOW = 60000L

    /**
     * Margin receiving window.
     */
    const val MARGIN_RECEIVING_WINDOW = 60000L

}