package com.binance.api.client.domain.account.margin


import com.binance.api.client.domain.TransferType
import com.fasterxml.jackson.annotation.JsonProperty

data class TransferHistory(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
    data class Row(
            @JsonProperty("amount")
            val amount: String,
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("status")
            val status: String,
            @JsonProperty("timestamp")
            val timestamp: Int,
            @JsonProperty("txId")
            val txId: Long,
            @JsonProperty("type")
            val type: TransferType
    )
}