package com.binance.api.client

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketMessage
import com.binance.api.client.domain.websocket.WebSocketStream
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class BinanceWebSocketClient(private val client: OkHttpClient, private val listener: WebSocketListener) {

    private var webSocket: WebSocket? = null
    private val objectMapper = ObjectMapper().registerKotlinModule()

    fun connect(channels: List<WebSocketStream>) {
        val streamingUrl =
            BinanceApiConstants.WS_API_BASE_URL + channels.joinToString(separator = "/") { it.toString() }
        val request = Request.Builder().url(streamingUrl).build()
        webSocket = client.newWebSocket(request, listener)
    }

    fun close() {
        webSocket?.let {
            val code = 1000
            listener.onClosing(it, code, "Closed by user")
            it.close(code, null)
            listener.onClosed(it, code, "Closed by user")
        }
    }

    fun message(message: WebSocketMessage) {
        val jsonString = objectMapper.writeValueAsString(message)
        webSocket?.send(jsonString)
    }

    interface WebSocketCallback {
        fun onEvent(eventWrapper: WebSocketEvent.Wrapper<WebSocketEvent>)
        fun onMessage(message: WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>) {}
        fun onFailure(cause: Throwable)
        fun onClosing(code: Int, reason: String) {}
    }

}