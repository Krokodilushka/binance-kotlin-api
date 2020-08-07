package com.binance.api.client.domain.event.deserializer

import com.binance.api.client.domain.event.CandlestickEvent
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
        val candlestickNode = node["k"]
        return CandlestickEvent(
                eventType = node["e"].asText(),
                eventTime = node["E"].asLong(),
                symbol = node["s"].asText(),
                interval = candlestickNode["i"].asText(),
                openTime = candlestickNode["t"].asLong(),
                closeTime = candlestickNode["T"].asLong(),
                firstTradeId = candlestickNode["f"].asLong(),
                lastTradeId = candlestickNode["L"].asLong(),
                open = candlestickNode["o"].asText(),
                close = candlestickNode["c"].asText(),
                high = candlestickNode["h"].asText(),
                low = candlestickNode["l"].asText(),
                baseAssetVolume = candlestickNode["v"].asText(),
                numberOfTrades = candlestickNode["n"].asLong(),
                isClosed = candlestickNode["x"].asBoolean(),
                quoteAssetVolume = candlestickNode["q"].asText(),
                takerBuyBaseAssetVolume = candlestickNode["V"].asText(),
                takerBuyQuoteAssetVolume = candlestickNode["Q"].asText()
        )
    }
}