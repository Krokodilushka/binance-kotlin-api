package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Account(
        @JsonProperty("borrowEnabled")
        val borrowEnabled: Boolean,
        @JsonProperty("marginLevel")
        val marginLevel: String,
        @JsonProperty("totalAssetOfBtc")
        val totalAssetOfBtc: String,
        @JsonProperty("totalLiabilityOfBtc")
        val totalLiabilityOfBtc: String,
        @JsonProperty("totalNetAssetOfBtc")
        val totalNetAssetOfBtc: String,
        @JsonProperty("tradeEnabled")
        val tradeEnabled: Boolean,
        @JsonProperty("transferEnabled")
        val transferEnabled: Boolean,
        @JsonProperty("userAssets")
        val userAssets: List<UserAsset>
) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class UserAsset(
                @JsonProperty("asset")
                val asset: String,
                @JsonProperty("borrowed")
                val borrowed: String,
                @JsonProperty("free")
                val free: String,
                @JsonProperty("interest")
                val interest: String,
                @JsonProperty("locked")
                val locked: String,
                @JsonProperty("netAsset")
                val netAsset: String
        )
}