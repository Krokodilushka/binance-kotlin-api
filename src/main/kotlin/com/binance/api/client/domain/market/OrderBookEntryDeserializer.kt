package com.binance.api.client.domain.market

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/**
 * Custom deserializer for an OrderBookEntry, since the API returns an array in the format [ price, qty, [] ].
 */
class OrderBookEntryDeserializer : JsonDeserializer<OrderBookEntry>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): OrderBookEntry {
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val price = node[0].asText()
        val qty = node[1].asText()
        val orderBookEntry = OrderBookEntry()
        orderBookEntry.price = price
        orderBookEntry.qty = qty
        return orderBookEntry
    }
}