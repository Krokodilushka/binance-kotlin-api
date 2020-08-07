package com.binance.api.domain.general

import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.general.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Test
import java.io.IOException
import java.util.*

/**
 * Test deserialization of exchange information.
 */
class ExchangeInfoDeserializerTest {
    @Test
    fun testExchangeInfoDeserialization() {
        val json = """{
  "timezone": "UTC",
  "serverTime": 1508631584636,
  "rateLimits": [{
      "rateLimitType": "REQUEST_WEIGHT",
      "interval": "MINUTE",
      "limit": 1200
    },
    {
      "rateLimitType": "ORDERS",
      "interval": "SECOND",
      "limit": 10
    },
    {
      "rateLimitType": "ORDERS",
      "interval": "DAY",
      "limit": 100000
    }
  ],
  "exchangeFilters": [],
  "symbols": [{
    "symbol": "ETHBTC",
    "status": "TRADING",
    "baseAsset": "ETH",
    "baseAssetPrecision": 8,
    "quoteAsset": "BTC",
    "quotePrecision": 8,
    "orderTypes": ["LIMIT", "MARKET"],
    "icebergAllowed": false,
    "filters": [{
      "filterType": "PRICE_FILTER",
      "minPrice": "0.00000100",
      "maxPrice": "100000.00000000",
      "tickSize": "0.00000100"
    }, {
      "filterType": "LOT_SIZE",
      "minQty": "0.00100000",
      "maxQty": "100000.00000000",
      "stepSize": "0.00100000"
    }, {
      "filterType": "MIN_NOTIONAL",
      "minNotional": "0.00100000"
    }]
  }]}"""
        val mapper = ObjectMapper()
        try {
            val exchangeInfo = mapper.readValue(json, ExchangeInfo::class.java)
            println(exchangeInfo)
            Assert.assertEquals(exchangeInfo.timezone, "UTC")
            Assert.assertEquals(exchangeInfo.serverTime as Long, 1508631584636L)
            val rateLimits = exchangeInfo.rateLimits
            Assert.assertEquals(rateLimits!!.size.toLong(), 3)
            testRateLimit(rateLimits[0], RateLimitType.REQUEST_WEIGHT, RateLimitInterval.MINUTE, 1200)
            testRateLimit(rateLimits[1], RateLimitType.ORDERS, RateLimitInterval.SECOND, 10)
            testRateLimit(rateLimits[2], RateLimitType.ORDERS, RateLimitInterval.DAY, 100000)
            val symbols = exchangeInfo.symbols
            Assert.assertEquals(symbols!!.size.toLong(), 1)
            val symbolInfo = symbols[0]
            Assert.assertEquals(symbolInfo.symbol, "ETHBTC")
            Assert.assertEquals(symbolInfo.status, SymbolStatus.TRADING)
            Assert.assertEquals(symbolInfo.baseAsset, "ETH")
            Assert.assertEquals(symbolInfo.baseAssetPrecision, 8)
            Assert.assertEquals(symbolInfo.quoteAsset, "BTC")
            Assert.assertEquals(symbolInfo.quotePrecision, 8)
            Assert.assertEquals(symbolInfo.orderTypes, Arrays.asList(OrderType.LIMIT, OrderType.MARKET))
            Assert.assertFalse(symbolInfo.isIcebergAllowed)
            val symbolFilters = symbolInfo.filters
            Assert.assertEquals(symbolFilters!!.size.toLong(), 3)
            val priceFilter = symbolFilters[0]
            Assert.assertEquals(priceFilter.filterType, FilterType.PRICE_FILTER)
            Assert.assertEquals(priceFilter.minPrice, "0.00000100")
            Assert.assertEquals(priceFilter.maxPrice, "100000.00000000")
            Assert.assertEquals(priceFilter.tickSize, "0.00000100")
            val lotSizeFilter = symbolFilters[1]
            Assert.assertEquals(lotSizeFilter.filterType, FilterType.LOT_SIZE)
            Assert.assertEquals(lotSizeFilter.minQty, "0.00100000")
            Assert.assertEquals(lotSizeFilter.maxQty, "100000.00000000")
            Assert.assertEquals(lotSizeFilter.stepSize, "0.00100000")
            val minNotionalFilter = symbolFilters[2]
            Assert.assertEquals(minNotionalFilter.filterType, FilterType.MIN_NOTIONAL)
            Assert.assertEquals(minNotionalFilter.minNotional, "0.00100000")
        } catch (e: IOException) {
            Assert.fail()
        }
    }

    private fun testRateLimit(rateLimit: RateLimit, expectedRateLimitType: RateLimitType, expectedInterval: RateLimitInterval, expectedLimit: Int) {
        Assert.assertEquals(rateLimit.rateLimitType, expectedRateLimitType)
        Assert.assertEquals(rateLimit.interval, expectedInterval)
        Assert.assertEquals(rateLimit.limit, expectedLimit)
    }
}