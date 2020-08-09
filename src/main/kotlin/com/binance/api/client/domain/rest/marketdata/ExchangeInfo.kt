package com.binance.api.client.domain.rest.marketdata


import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.ExchangeFilter
import com.binance.api.client.domain.rest.SymbolFilter
import com.binance.api.client.domain.websocket.deserializer.ExchangeFilterDeserializer
import com.binance.api.client.domain.websocket.deserializer.SymbolFilterDeserializer
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

data class ExchangeInfo(
        @JsonProperty("timezone")
        val timezone: String,
        @JsonProperty("serverTime")
        val serverTime: Long,
        @JsonProperty("rateLimits")
        val rateLimits: List<RateLimit>,
        @JsonDeserialize(contentUsing = ExchangeFilterDeserializer::class)
        @JsonProperty("exchangeFilters")
        val exchangeFilters: List<ExchangeFilter>,
        @JsonProperty("symbols")
        val symbols: List<Symbol>
) {

    data class Symbol(
            @JsonProperty("symbol")
            val symbol: String,
            @JsonProperty("status")
            val status: SymbolStatus,
            @JsonProperty("baseAsset")
            val baseAsset: String,
            @JsonProperty("baseAssetPrecision")
            val baseAssetPrecision: Int,
            @JsonProperty("baseCommissionPrecision")
            val baseCommissionPrecision: Int,
            @JsonProperty("quoteAsset")
            val quoteAsset: String,
            @JsonProperty("quotePrecision")
            val quotePrecision: Int,
            @JsonProperty("quoteAssetPrecision")
            val quoteAssetPrecision: Int,
            @JsonProperty("quoteCommissionPrecision")
            val quoteCommissionPrecision: Int,
            @JsonProperty("quoteOrderQtyMarketAllowed")
            val quoteOrderQtyMarketAllowed: Boolean,
            @JsonProperty("orderTypes")
            val orderTypes: List<OrderType>,
            @JsonProperty("icebergAllowed")
            val icebergAllowed: Boolean,
            @JsonProperty("ocoAllowed")
            val ocoAllowed: Boolean,
            @JsonProperty("isSpotTradingAllowed")
            val isSpotTradingAllowed: Boolean,
            @JsonProperty("isMarginTradingAllowed")
            val isMarginTradingAllowed: Boolean,
            @JsonProperty("filters")
            @JsonDeserialize(contentUsing = SymbolFilterDeserializer::class)
            val filters: List<SymbolFilter>,
            @JsonProperty("permissions")
            val permissions: List<Permission>
    )

    data class RateLimit(
            @JsonProperty("rateLimitType")
            val rateLimitType: RateLimitType,
            @JsonProperty("interval")
            val interval: RateLimitInterval,
            @JsonProperty("intervalNum")
            val intervalNum: Int,
            @JsonProperty("limit")
            val limit: Int
    )
}