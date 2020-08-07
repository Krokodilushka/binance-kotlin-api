package com.binance.api.client.domain.event

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException

/**
 * Custom serializer for a candlestick stream event, since the structure of the candlestick json differ from the one in the REST API.
 *
 * @see CandlestickEvent
 */
class CandlestickEventSerializer : JsonSerializer<CandlestickEvent>() {
    @Throws(IOException::class)
    override fun serialize(candlestickEvent: CandlestickEvent, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()

        // Write header
        gen.writeStringField("e", candlestickEvent.eventType)
        gen.writeNumberField("E", candlestickEvent.eventTime)
        gen.writeStringField("s", candlestickEvent.symbol)

        // Write candlestick data
        gen.writeObjectFieldStart("k")
        gen.writeNumberField("t", candlestickEvent.openTime!!)
        gen.writeNumberField("T", candlestickEvent.closeTime!!)
        gen.writeStringField("i", candlestickEvent.intervalId)
        gen.writeNumberField("f", candlestickEvent.firstTradeId!!)
        gen.writeNumberField("L", candlestickEvent.lastTradeId!!)
        gen.writeStringField("o", candlestickEvent.open)
        gen.writeStringField("c", candlestickEvent.close)
        gen.writeStringField("h", candlestickEvent.high)
        gen.writeStringField("l", candlestickEvent.low)
        gen.writeStringField("v", candlestickEvent.volume)
        gen.writeNumberField("n", candlestickEvent.numberOfTrades!!)
        gen.writeBooleanField("x", candlestickEvent.barFinal!!)
        gen.writeStringField("q", candlestickEvent.quoteAssetVolume)
        gen.writeStringField("V", candlestickEvent.takerBuyBaseAssetVolume)
        gen.writeStringField("Q", candlestickEvent.takerBuyQuoteAssetVolume)
        gen.writeEndObject()
    }
}