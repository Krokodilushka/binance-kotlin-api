package com.binance.api.client.domain.rest.unofficial


import com.fasterxml.jackson.annotation.JsonProperty

data class PairVipLevel(
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
        @JsonProperty("marginRatio")
        val marginRatio: String,
        @JsonProperty("base")
        val base: Asset,
        @JsonProperty("quote")
        val quote: Asset
    ) {
        data class Asset(
            @JsonProperty("assetName")
            val assetName: String,
            @JsonProperty("levelDetails")
            val levelDetails: List<LevelDetail>,
            @JsonProperty("custom")
            val custom: String?
        ) {
            data class LevelDetail(
                @JsonProperty("level")
                val level: Int,
                @JsonProperty("maxBorrowable")
                val maxBorrowable: String,
                @JsonProperty("interestRate")
                val interestRate: String
            )
        }
    }
}