package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrossMarginAsset(
        @JsonProperty("assetFullName")
        val assetFullName: String,
        @JsonProperty("assetName")
        val assetName: String,
        @JsonProperty("isBorrowable")
        val isBorrowable: Boolean,
        @JsonProperty("isMortgageable")
        val isMortgageable: Boolean,
        @JsonProperty("userMinBorrow")
        val userMinBorrow: String,
        @JsonProperty("userMinRepay")
        val userMinRepay: String
)