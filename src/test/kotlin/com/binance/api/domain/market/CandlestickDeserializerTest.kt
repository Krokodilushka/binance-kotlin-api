package com.binance.api.domain.market

import com.binance.api.client.domain.market.Candlestick
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Test
import java.io.IOException

/**
 * Tests the adequate deserialization of candlestick JSON information.
 */
class CandlestickDeserializerTest {
    @Test
    fun testCandlestickDeserializerTest() {
        val candlestickJson = """[
    1499040000000,
        "0.01634790",
        "0.80000000",
        "0.01575800",
        "0.01577100",
        "148976.11427815",
        1499644799999,
        "2434.19055334",
        308,
        "1756.87402397",
        "28.46694368",
        "17928899.62484339"
        ]"""
        val mapper = ObjectMapper()
        try {
            val candlestick = mapper.readValue(candlestickJson, Candlestick::class.java)
            Assert.assertEquals(candlestick.openTime as Long, 1499040000000L)
            Assert.assertEquals(candlestick.open, "0.01634790")
            Assert.assertEquals(candlestick.high, "0.80000000")
            Assert.assertEquals(candlestick.low, "0.01575800")
            Assert.assertEquals(candlestick.close, "0.01577100")
            Assert.assertEquals(candlestick.volume, "148976.11427815")
            Assert.assertEquals(candlestick.closeTime as Long, 1499644799999L)
            Assert.assertEquals(candlestick.quoteAssetVolume, "2434.19055334")
            Assert.assertEquals(candlestick.numberOfTrades as Long, 308L)
            Assert.assertEquals(candlestick.takerBuyBaseAssetVolume, "1756.87402397")
            Assert.assertEquals(candlestick.takerBuyQuoteAssetVolume, "28.46694368")
        } catch (e: IOException) {
            Assert.fail()
        }
    }
}