package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

class OrderBookEntryDeserializer : JsonDeserializer<WebSocketEvent.MarketEvent.DepthEvent.OrderBookEntry>() {
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): WebSocketEvent.MarketEvent.DepthEvent.OrderBookEntry {
        val node = jp.codec.readTree<JsonNode>(jp)
        return WebSocketEvent.MarketEvent.DepthEvent.OrderBookEntry(node[0].asText(), node[1].asText())
    }
}