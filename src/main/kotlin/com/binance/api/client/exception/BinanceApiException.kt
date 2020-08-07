package com.binance.api.client.exception

import com.binance.api.client.BinanceApiError

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
class BinanceApiException : RuntimeException {
    /**
     * @return the response error object from Binance API, or null if no response object was returned (e.g. server returned 500).
     */
    /**
     * Error response object returned by Binance API.
     */
    var error: BinanceApiError? = null
        private set

    /**
     * Instantiates a new binance api exception.
     *
     * @param error an error response object
     */
    constructor(error: BinanceApiError?) {
        this.error = error
    }

    /**
     * Instantiates a new binance api exception.
     */
    constructor() : super()

    /**
     * Instantiates a new binance api exception.
     *
     * @param message the message
     */
    constructor(message: String?) : super(message)

    /**
     * Instantiates a new binance api exception.
     *
     * @param cause the cause
     */
    constructor(cause: Throwable?) : super(cause)

    /**
     * Instantiates a new binance api exception.
     *
     * @param message the message
     * @param cause the cause
     */
    constructor(message: String?, cause: Throwable?) : super(message, cause)

    override val message: String
        get() = if (error != null) {
            error!!.msg!!
        } else super.message!!

    companion object {
        private const val serialVersionUID = 3788669840036201041L
    }
}