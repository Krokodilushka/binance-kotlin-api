package com.binance.api.client.domain.rest.unofficial

import com.fasterxml.jackson.annotation.JsonProperty

data class PairListed(
    @JsonProperty("code")
    val code: Int,
    @JsonProperty("message")
    val message: String?,
    @JsonProperty("messageDetail")
    val messageDetail: String?,
    @JsonProperty("data")
    val `data`: List<Data>,
    @JsonProperty("success")
    val success: Boolean
) {
    data class Data(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("base")
        val base: String,
        @JsonProperty("quote")
        val quote: String,
        @JsonProperty("marginRatio")
        val marginRatio: String,
        @JsonProperty("isTradeAllowed")
        val isTradeAllowed: Boolean,
        @JsonProperty("isBuyAllowed")
        val isBuyAllowed: Boolean,
        @JsonProperty("isSellAllowed")
        val isSellAllowed: Boolean,
        @JsonProperty("isBaseBorrowable")
        val isBaseBorrowable: Boolean,
        @JsonProperty("isQuoteBorrowable")
        val isQuoteBorrowable: Boolean,
        @JsonProperty("isBaseTransferIn")
        val isBaseTransferIn: Boolean,
        @JsonProperty("isQuoteTransferIn")
        val isQuoteTransferIn: Boolean,
        @JsonProperty("status")
        val status: String,
        @JsonProperty("delistTime")
        val delistTime: String?
    )
}