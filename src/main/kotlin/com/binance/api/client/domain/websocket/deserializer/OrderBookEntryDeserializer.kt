package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.MarketEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/**
 * Custom deserializer for an OrderBookEntry, since the API returns an array in the format [ price, qty, [] ].
 */
class OrderBookEntryDeserializer : JsonDeserializer<MarketEvent.DepthEvent.OrderBookEntry>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): MarketEvent.DepthEvent.OrderBookEntry {
        val node = jp.codec.readTree<JsonNode>(jp)
        return MarketEvent.DepthEvent.OrderBookEntry(node[0].asText(), node[1].asText())
    }
}