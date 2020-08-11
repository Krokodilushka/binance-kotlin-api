package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.UserDataEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


class UserDataUpdateEventDeserializer : JsonDeserializer<UserDataEvent>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): UserDataEvent {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventType = node["e"].asText()
        val event = when (eventType) {
            "outboundAccountInfo" -> JsonToObject.convert(json, UserDataEvent.Event.AccountInfo::class.java)
            "outboundAccountPosition" -> JsonToObject.convert(json, UserDataEvent.Event.AccountPosition::class.java)
            "balanceUpdate" -> JsonToObject.convert(json, UserDataEvent.Event.BalanceUpdateEvent::class.java)
            "executionReport" -> JsonToObject.convert(json, UserDataEvent.Event.OrderTradeUpdateEvent::class.java)
            "listStatus" -> JsonToObject.convert(json, UserDataEvent.Event.OcoOrderTradeUpdateEvent::class.java)
            else -> throw IllegalArgumentException("event $eventType not found")
        }
        return UserDataEvent(event)
    }

}