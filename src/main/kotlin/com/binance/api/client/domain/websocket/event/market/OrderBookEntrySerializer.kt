package com.binance.api.client.domain.websocket.event.market

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException

/**
 * Custom serializer for an OrderBookEntry.
 */
class OrderBookEntrySerializer : JsonSerializer<OrderBookEntry>() {
    @Throws(IOException::class)
    override fun serialize(orderBookEntry: OrderBookEntry, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartArray()
        gen.writeString(orderBookEntry.price)
        gen.writeString(orderBookEntry.qty)
        gen.writeEndArray()
    }
}