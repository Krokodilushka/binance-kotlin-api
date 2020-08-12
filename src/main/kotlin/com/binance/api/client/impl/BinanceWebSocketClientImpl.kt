package com.binance.api.client.impl

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.websocket.WebSocketMessage
import com.binance.api.client.domain.websocket.WebSocketStream
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class BinanceWebSocketClientImpl(private val client: OkHttpClient, private val listener: WebSocketListener) : BinanceWebSocketClient {

    private var webSocket: WebSocket? = null
    private val objectMapper = ObjectMapper().registerKotlinModule()

    override fun connect(channels: List<WebSocketStream>) {
        webSocket.let {
            this.close()
        }
        val streamingUrl = BinanceApiConstants.WS_API_BASE_URL + channels.joinToString(separator = "/") { it.toString() }
        val request = Request.Builder().url(streamingUrl).build()
        webSocket = client.newWebSocket(request, listener)
    }

    override fun close() {
        webSocket?.let {
            val code = 1000
            listener.onClosing(it, code, "Closed by user")
            it.close(code, null)
            listener.onClosed(it, code, "Closed by user")
        }
    }

    override fun message(message: WebSocketMessage) {
        val jsonString = objectMapper.writeValueAsString(message)
        webSocket?.send(jsonString)
    }

}