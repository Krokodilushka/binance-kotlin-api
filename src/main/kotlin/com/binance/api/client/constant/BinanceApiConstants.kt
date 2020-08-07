package com.binance.api.client.constant

import org.apache.commons.lang3.builder.ToStringStyle

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
    const val WS_API_BASE_URL = "wss://stream.binance.com:9443/ws"

    /**
     * Asset info base URL.
     */
    const val ASSET_INFO_API_BASE_URL = "https://www.binance.com/"

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
     * Default receiving window.
     */
    const val DEFAULT_RECEIVING_WINDOW = 60000L

    /**
     * Default margin receiving window.
     */
    const val DEFAULT_MARGIN_RECEIVING_WINDOW = 5000L

    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     * - Example ToStringStyle.JSON_STYLE
     */
    var TO_STRING_BUILDER_STYLE: ToStringStyle = ToStringStyle.SHORT_PREFIX_STYLE
}