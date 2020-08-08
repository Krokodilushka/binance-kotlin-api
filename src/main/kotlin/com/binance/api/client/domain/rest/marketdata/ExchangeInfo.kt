package com.binance.api.client.domain.rest.marketdata


import com.binance.api.client.domain.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class ExchangeInfo(
        @JsonProperty("timezone")
        val timezone: String,
        @JsonProperty("serverTime")
        val serverTime: Long,
        @JsonProperty("rateLimits")
        val rateLimits: List<RateLimit>,
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
            val filters: List<SymbolFilter>,
            @JsonProperty("permissions")
            val permissions: List<Permission>
    )

    @JsonIgnoreProperties
    data class ExchangeFilter(
            val filterType: String?,
            val maxPosition: String?,
            val maxNumOrders: String?,
            val maxNumAlgoOrders: String?
    )

    data class SymbolFilter(
            val filterType: FilterType,
            val minPrice: String?,
            val maxPrice: String?,
            val tickSize: String?,
            val multiplierUp: String?,
            val multiplierDown: String?,
            val avgPriceMins: String?,
            val minQty: String?,
            val maxQty: String?,
            val stepSize: String?,
            val minNotional: String?,
            val applyToMarket: String?,
            val limit: String?,
            val maxNumOrders: String?,
            val maxNumAlgoOrders: String?,
            val maxNumIcebergOrders: String?
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