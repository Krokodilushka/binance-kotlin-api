package com.binance.api.client.domain.rest.margin


import com.binance.api.client.domain.TransactionTarget
import com.fasterxml.jackson.annotation.JsonProperty

data class IsolatedTransferHistory(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Int
) {
    data class Row(
            @JsonProperty("amount")
            val amount: String,
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("status")
            val status: String,
            @JsonProperty("timestamp")
            val timestamp: Long,
            @JsonProperty("txId")
            val txId: Long,
            @JsonProperty("transFrom")
            val transFrom: TransactionTarget,
            @JsonProperty("transTo")
            val transTo: TransactionTarget
    )
}