package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


class UserDataUpdateEventDeserializer : JsonDeserializer<WebSocketEvent.UserDataEvent>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): WebSocketEvent.UserDataEvent {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventType = node["e"].asText()
        val event = when (eventType) {
            "outboundAccountInfo" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.AccountInfo::class.java)
            "outboundAccountPosition" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.AccountPosition::class.java)
            "balanceUpdate" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.BalanceUpdateEvent::class.java)
            "executionReport" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.OrderTradeUpdateEvent::class.java)
            "listStatus" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.OcoOrderTradeUpdateEvent::class.java)
            else -> throw IllegalArgumentException("event $eventType not found")
        }
        return WebSocketEvent.UserDataEvent(event)
    }

}