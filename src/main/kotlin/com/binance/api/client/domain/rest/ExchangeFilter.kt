package com.binance.api.client.domain.rest

import com.binance.api.client.domain.ExchangeFilterType
import com.fasterxml.jackson.annotation.JsonProperty


sealed class ExchangeFilter {
    data class ExchangeMaxNumOrders(
            @JsonProperty("filterType")
            val filterType: ExchangeFilterType,
            @JsonProperty("maxNumOrders")
            val maxNumOrders: Int
    ) : ExchangeFilter()

    data class ExchangeMaxAlgoOrders(
            @JsonProperty("filterType")
            val filterType: ExchangeFilterType,
            @JsonProperty("maxNumAlgoOrders")
            val maxNumAlgoOrders: Int
    ) : ExchangeFilter()
}