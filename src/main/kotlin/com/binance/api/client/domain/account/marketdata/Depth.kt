package com.binance.api.client.domain.account.marketdata


import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


data class Depth(
        @JsonProperty("lastUpdateId")
        val lastUpdateId: Long,
        @JsonProperty("bids")
        val bids: List<Element>,
        @JsonProperty("asks")
        val asks: List<Element>
) {
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @JsonPropertyOrder
    data class Element(
            val price: String,
            val qty: String
    )
}