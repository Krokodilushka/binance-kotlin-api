package com.binance.api.client.domain.rest

import com.binance.api.client.domain.SymbolFilterType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

sealed class SymbolFilter {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class PriceFilter(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("minPrice")
            val minPrice: String,
            @JsonProperty("maxPrice")
            val maxPrice: String,
            @JsonProperty("tickSize")
            val tickSize: String
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class PercentPrice(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("multiplierUp")
            val multiplierUp: String,
            @JsonProperty("multiplierDown")
            val multiplierDown: String,
            @JsonProperty("avgPriceMins")
            val avgPriceMins: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class LotSize(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("minQty")
            val minQty: String,
            @JsonProperty("maxQty")
            val maxQty: String,
            @JsonProperty("stepSize")
            val stepSize: String
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MinNotional(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("minNotional")
            val minNotional: String,
            @JsonProperty("applyToMarket")
            val applyToMarket: Boolean,
            @JsonProperty("avgPriceMins")
            val avgPriceMins: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class IcebergParts(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("limit")
            val limit: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MarketLotSize(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("minQty")
            val minQty: String,
            @JsonProperty("maxQty")
            val maxQty: String,
            @JsonProperty("stepSize")
            val stepSize: String
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MaxNumOrders(
            @JsonProperty("filterType")
            val filterType: String,
            @JsonProperty("maxNumOrders")
            val maxNumOrders: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MaxNumAlgoOrders(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("maxNumAlgoOrders")
            val maxNumAlgoOrders: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MaxNumIcebergOrders(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("maxNumIcebergOrders")
            val maxNumIcebergOrders: Int
    ) : SymbolFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MaxPosition(
            @JsonProperty("filterType")
            val filterType: SymbolFilterType,
            @JsonProperty("maxPosition")
            val maxPosition: String
    ) : SymbolFilter()
}