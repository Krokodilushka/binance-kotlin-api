package com.binance.api.client.domain.rest.margin

import com.fasterxml.jackson.annotation.JsonProperty

data class IsolatedAccountInfo(
        @JsonProperty("assets")
        val assets: List<Asset>,
        @JsonProperty("totalAssetOfBtc")
        val totalAssetOfBtc: String,
        @JsonProperty("totalLiabilityOfBtc")
        val totalLiabilityOfBtc: String,
        @JsonProperty("totalNetAssetOfBtc")
        val totalNetAssetOfBtc: String
) {
    data class Asset(
            @JsonProperty("baseAsset")
            val baseAsset: Asset,
            @JsonProperty("quoteAsset")
            val quoteAsset: Asset,
            @JsonProperty("symbol")
            val symbol: String,
            @JsonProperty("isolatedCreated")
            val isolatedCreated: Boolean,
            @JsonProperty("marginLevel")
            val marginLevel: String,
            @JsonProperty("marginLevelStatus")
            val marginLevelStatus: MarginLevelStatus,
            @JsonProperty("marginRatio")
            val marginRatio: String,
            @JsonProperty("indexPrice")
            val indexPrice: String,
            @JsonProperty("liquidatePrice")
            val liquidatePrice: String,
            @JsonProperty("liquidateRate")
            val liquidateRate: String,
            @JsonProperty("tradeEnabled")
            val tradeEnabled: Boolean
    ) {
        data class Asset(
                @JsonProperty("asset")
                val asset: String,
                @JsonProperty("borrowEnabled")
                val borrowEnabled: Boolean,
                @JsonProperty("borrowed")
                val borrowed: String,
                @JsonProperty("free")
                val free: String,
                @JsonProperty("interest")
                val interest: String,
                @JsonProperty("locked")
                val locked: String,
                @JsonProperty("netAsset")
                val netAsset: String,
                @JsonProperty("netAssetOfBtc")
                val netAssetOfBtc: String,
                @JsonProperty("repayEnabled")
                val repayEnabled: Boolean,
                @JsonProperty("totalAsset")
                val totalAsset: String
        )

        enum class MarginLevelStatus {
            EXCESSIVE, NORMAL, MARGIN_CALL, PRE_LIQUIDATION, FORCE_LIQUIDATION
        }
    }
}