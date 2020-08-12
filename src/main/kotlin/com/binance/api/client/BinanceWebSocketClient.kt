package com.binance.api.client

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketMessage
import com.binance.api.client.domain.websocket.WebSocketStream

interface BinanceWebSocketClient {

    fun connect(channels: List<WebSocketStream>)

    fun close()

    fun message(message: WebSocketMessage)

    interface WebSocketCallback {
        fun onEvent(eventWrapper: WebSocketEvent.Wrapper<WebSocketEvent>)
        fun onMessage(message: WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>) {}
        fun onFailure(cause: Throwable)
        fun onClosing(code: Int, reason: String) {}
    }
}
