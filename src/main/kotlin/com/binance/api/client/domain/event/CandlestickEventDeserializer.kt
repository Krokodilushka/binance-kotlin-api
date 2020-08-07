package com.binance.api.client.domain.event

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/**
 * Custom deserializer for a candlestick stream event, since the structure of the candlestick json differ from the one in the REST API.
 *
 * @see CandlestickEvent
 */
class CandlestickEventDeserializer : JsonDeserializer<CandlestickEvent>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): CandlestickEvent {
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val candlestickEvent = CandlestickEvent()

        // Parse header
        candlestickEvent.eventType = node["e"].asText()
        candlestickEvent.eventTime = node["E"].asLong()
        candlestickEvent.symbol = node["s"].asText()

        // Parse candlestick data
        val candlestickNode = node["k"]
        candlestickEvent.openTime = candlestickNode["t"].asLong()
        candlestickEvent.closeTime = candlestickNode["T"].asLong()
        candlestickEvent.intervalId = candlestickNode["i"].asText()
        candlestickEvent.firstTradeId = candlestickNode["f"].asLong()
        candlestickEvent.lastTradeId = candlestickNode["L"].asLong()
        candlestickEvent.open = candlestickNode["o"].asText()
        candlestickEvent.close = candlestickNode["c"].asText()
        candlestickEvent.high = candlestickNode["h"].asText()
        candlestickEvent.low = candlestickNode["l"].asText()
        candlestickEvent.volume = candlestickNode["v"].asText()
        candlestickEvent.numberOfTrades = candlestickNode["n"].asLong()
        candlestickEvent.barFinal = candlestickNode["x"].asBoolean()
        candlestickEvent.quoteAssetVolume = candlestickNode["q"].asText()
        candlestickEvent.takerBuyBaseAssetVolume = candlestickNode["V"].asText()
        candlestickEvent.takerBuyQuoteAssetVolume = candlestickNode["Q"].asText()
        return candlestickEvent
    }
}