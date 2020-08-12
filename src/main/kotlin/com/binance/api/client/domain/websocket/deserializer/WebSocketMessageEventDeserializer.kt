package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketMessage
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


class WebSocketMessageEventDeserializer : JsonDeserializer<WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>>() {
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>? {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        node["result"]?.let {
            val result = JsonToObject.convert(json, WebSocketMessage.Wrapper.Response.Result::class.java)
            return WebSocketMessage.Wrapper(response = result)
        }
        node["error"]?.let {
            val result = JsonToObject.convert(json, WebSocketMessage.Wrapper.Response.Error::class.java)
            return WebSocketMessage.Wrapper(response = result)
        }
        return null
    }
}