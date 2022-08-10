package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.SymbolFilterType
import com.binance.api.client.domain.rest.SymbolFilter
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

class SymbolFilterDeserializer : JsonDeserializer<SymbolFilter>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): SymbolFilter {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        return when (SymbolFilterType.valueOf(node["filterType"].asText())) {
            SymbolFilterType.PRICE_FILTER -> JsonToObject.convert(json, SymbolFilter.PriceFilter::class.java)
            SymbolFilterType.PERCENT_PRICE -> JsonToObject.convert(json, SymbolFilter.PercentPrice::class.java)
            SymbolFilterType.LOT_SIZE -> JsonToObject.convert(json, SymbolFilter.LotSize::class.java)
            SymbolFilterType.MIN_NOTIONAL -> JsonToObject.convert(json, SymbolFilter.MinNotional::class.java)
            SymbolFilterType.MAX_NUM_ORDERS -> JsonToObject.convert(json, SymbolFilter.MaxNumOrders::class.java)
            SymbolFilterType.MAX_NUM_ALGO_ORDERS -> JsonToObject.convert(json, SymbolFilter.MaxNumAlgoOrders::class.java)
            SymbolFilterType.ICEBERG_PARTS -> JsonToObject.convert(json, SymbolFilter.IcebergParts::class.java)
            SymbolFilterType.MARKET_LOT_SIZE -> JsonToObject.convert(json, SymbolFilter.MarketLotSize::class.java)
            SymbolFilterType.MAX_NUM_ICEBERG_ORDERS -> JsonToObject.convert(json, SymbolFilter.MaxNumIcebergOrders::class.java)
            SymbolFilterType.MAX_POSITION -> JsonToObject.convert(json, SymbolFilter.MaxPosition::class.java)
            SymbolFilterType.TRAILING_DELTA -> JsonToObject.convert(json, SymbolFilter.TrailingDelta::class.java)
            SymbolFilterType.PERCENT_PRICE_BY_SIDE -> JsonToObject.convert(json, SymbolFilter.PercentPriceBySide::class.java)
        }
    }

}