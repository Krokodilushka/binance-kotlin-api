package com.binance.api.client.domain.account.marketdata


import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.Permission
import com.binance.api.client.domain.general.ExchangeFilter
import com.binance.api.client.domain.general.RateLimit
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
            val status: String,
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
            val filters: List<ExchangeFilter>,
            @JsonProperty("permissions")
            val permissions: List<Permission>
    )
}