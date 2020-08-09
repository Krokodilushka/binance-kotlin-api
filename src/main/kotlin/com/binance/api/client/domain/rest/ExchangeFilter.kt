package com.binance.api.client.domain.rest

import com.binance.api.client.domain.ExchangeFilterType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


sealed class ExchangeFilter {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ExchangeMaxNumOrders(
            @JsonProperty("filterType")
            val filterType: ExchangeFilterType,
            @JsonProperty("maxNumOrders")
            val maxNumOrders: Int
    ) : ExchangeFilter()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ExchangeMaxAlgoOrders(
            @JsonProperty("filterType")
            val filterType: ExchangeFilterType,
            @JsonProperty("maxNumAlgoOrders")
            val maxNumAlgoOrders: Int
    ) : ExchangeFilter()
}