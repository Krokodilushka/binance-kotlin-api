package com.binance.api.client

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketMessage
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class BinanceApiWebSocketListener(private val callback: BinanceWebSocketClient.WebSocketCallback) :
    WebSocketListener() {

    private val mapper = ObjectMapper().registerKotlinModule()
    private val eventWrapperReader = mapper.readerFor(WebSocketEvent.Wrapper::class.java)
    private val messageWrapperReader = mapper.readerFor(WebSocketMessage.Wrapper::class.java)
    private var isClosed = false

    override fun onMessage(webSocket: WebSocket, text: String) {
        textToEventWrapper(text)?.let {
            callback.onEvent(it)
        } ?: textToMessageResponse(text)?.let {
            callback.onMessage(it)
        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        isClosed = true
        callback.onClosing(code, reason)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        if (!isClosed) {
            callback.onFailure(t)
        }
    }

    private fun textToEventWrapper(text: String): WebSocketEvent.Wrapper<WebSocketEvent>? {
        return eventWrapperReader.readValue<WebSocketEvent.Wrapper<WebSocketEvent>>(text)
    }

    private fun textToMessageResponse(text: String): WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>? {
        return messageWrapperReader.readValue<WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>>(text)
    }
}