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
        val eventTypeId = node["e"].asText()
        val event = when (eventTypeId) {
            "outboundAccountInfo", "outboundAccountPosition" -> JsonToObject.convert(json, UserDataEvent.Event.AccountUpdateEvent::class.java)
            "balanceUpdate" -> JsonToObject.convert(json, UserDataEvent.Event.BalanceUpdateEvent::class.java)
            "executionReport" -> JsonToObject.convert(json, UserDataEvent.Event.OrderTradeUpdateEvent::class.java)
            else -> throw IllegalArgumentException("event $eventTypeId not found")
        }
        return UserDataEvent(event)
    }

}