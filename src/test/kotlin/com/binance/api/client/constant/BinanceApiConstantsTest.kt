package com.binance.api.client.constant

import com.binance.api.client.constant.BinanceApiConstants.TO_STRING_BUILDER_STYLE
import com.binance.api.client.domain.market.Candlestick
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.lang3.builder.ToStringStyle
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import java.io.IOException

/**
 * @see BinanceApiConstants
 */
class BinanceApiConstantsTest {
    @Test
    fun testToStringBuilderStyleChange() {
        val binaceApiDefaultStyle = "Candlestick[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]"
        Assert.assertEquals(candlestick.toString(), binaceApiDefaultStyle)
        TO_STRING_BUILDER_STYLE = ToStringStyle.JSON_STYLE
        val jsonSyle = "{\"openTime\":1499040000000,\"open\":\"0.01634790\",\"high\":\"0.80000000\",\"low\":\"0.01575800\",\"close\":\"0.01577100\",\"volume\":\"148976.11427815\",\"closeTime\":1499644799999,\"quoteAssetVolume\":\"2434.19055334\",\"numberOfTrades\":308,\"takerBuyBaseAssetVolume\":\"1756.87402397\",\"takerBuyQuoteAssetVolume\":\"28.46694368\"}"
        Assert.assertEquals(candlestick.toString(), jsonSyle)
        TO_STRING_BUILDER_STYLE = ToStringStyle.NO_CLASS_NAME_STYLE
        val noClassNameSyle = "[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]"
        Assert.assertEquals(candlestick.toString(), noClassNameSyle)
        TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE
        val shortPrefixSyle = "Candlestick[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]"
        Assert.assertEquals(candlestick.toString(), shortPrefixSyle)
        TO_STRING_BUILDER_STYLE = ToStringStyle.SIMPLE_STYLE
        val simpleSyle = "1499040000000,0.01634790,0.80000000,0.01575800,0.01577100,148976.11427815,1499644799999,2434.19055334,308,1756.87402397,28.46694368"
        Assert.assertEquals(candlestick.toString(), simpleSyle)
    }

    companion object {
        private lateinit var candlestick: Candlestick
        private var DEFAULT_TO_STRING_BUILDER_STYLE: ToStringStyle? = null

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            DEFAULT_TO_STRING_BUILDER_STYLE = TO_STRING_BUILDER_STYLE
            val candlestickRaw = """[
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
                candlestick = mapper.readValue(candlestickRaw, Candlestick::class.java)
            } catch (e: IOException) {
                Assert.fail()
            }
        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            TO_STRING_BUILDER_STYLE = DEFAULT_TO_STRING_BUILDER_STYLE!!
        }
    }
}