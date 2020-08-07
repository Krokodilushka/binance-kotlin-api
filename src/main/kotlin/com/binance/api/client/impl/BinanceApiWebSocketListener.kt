package com.binance.api.client.impl

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.io.IOException

/**
 * Binance API WebSocket listener.
 */
class BinanceApiWebSocketListener<T> : WebSocketListener {
    private var callback: BinanceApiCallback<T>
    private val objectReader: ObjectReader
    private var closing = false

    constructor(callback: BinanceApiCallback<T>, eventClass: Class<T>?) {
        this.callback = callback
        objectReader = mapper.readerFor(eventClass)
    }

    constructor(callback: BinanceApiCallback<T>, eventTypeReference: TypeReference<T>?) {
        this.callback = callback
        objectReader = mapper.readerFor(eventTypeReference)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        try {
            val event: T = objectReader.readValue(text)
            callback.onResponse(event)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        closing = true
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        if (!closing) {
            callback.onFailure(t)
        }
    }

    companion object {
        private val mapper = ObjectMapper()
    }
}