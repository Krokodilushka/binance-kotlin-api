package com.binance.api.domain.event

import com.binance.api.client.domain.event.CandlestickEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Test
import java.io.IOException

/**
 * Tests that JSON responses from ta candlestick event are converted to the appropriate `CandlestickEvent` object.
 */
class CandlestickEventDeserializerTest {
    @Test
    fun testCandlestickEventDeserializer() {
        val candlestickEventJson = """{
        "e": "kline",
        "E": 1,
        "s": "ETHBTC",
        "k": {
        "t": 1499404860000,
        "T": 1499404919999,
        "s": "ETHBTC", 
        "i": "1m",
        "f": 77462, 
        "L": 77465, 
        "o": "0.10278577", 
        "c": "0.10278645", 
        "h": "0.10278712", 
        "l": "0.10278518", 
        "v": "17.47929838", 
        "n": 4, 
        "x": false, 
        "q": "1.79662878", 
        "V": "2.34879839", 
        "Q": "0.24142166", 
        "B": "13279784.01349473"
      }}"""
        val mapper = ObjectMapper()
        try {
            val candlestickEvent = mapper.readValue(candlestickEventJson, CandlestickEvent::class.java)
            Assert.assertEquals(candlestickEvent.eventType, "kline")
            Assert.assertEquals(candlestickEvent.eventTime, 1L)
            Assert.assertEquals(candlestickEvent.symbol, "ETHBTC")
            Assert.assertEquals(candlestickEvent.openTime, 1499404860000L)
            Assert.assertEquals(candlestickEvent.open, "0.10278577")
            Assert.assertEquals(candlestickEvent.high, "0.10278712")
            Assert.assertEquals(candlestickEvent.low, "0.10278518")
            Assert.assertEquals(candlestickEvent.close, "0.10278645")
            Assert.assertEquals(candlestickEvent.baseAssetVolume, "17.47929838")
            Assert.assertEquals(candlestickEvent.closeTime, 1499404919999L)
            Assert.assertEquals(candlestickEvent.interval, "1m")
            Assert.assertEquals(candlestickEvent.firstTradeId, 77462L)
            Assert.assertEquals(candlestickEvent.lastTradeId, 77465L)
            Assert.assertEquals(candlestickEvent.quoteAssetVolume, "1.79662878")
            Assert.assertEquals(candlestickEvent.numberOfTrades, 4L)
            Assert.assertEquals(candlestickEvent.takerBuyBaseAssetVolume, "2.34879839")
            Assert.assertEquals(candlestickEvent.takerBuyQuoteAssetVolume, "0.24142166")
            Assert.assertEquals(candlestickEvent.isClosed, false)
        } catch (e: IOException) {
            Assert.fail(e.message)
        }
    }
}