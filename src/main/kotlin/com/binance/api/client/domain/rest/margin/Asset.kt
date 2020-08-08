package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class Asset(
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