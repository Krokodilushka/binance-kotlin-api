package com.binance.api.client.domain.rest.margin


import com.binance.api.client.domain.CrossMarginTransferType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TransferHistory(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
        @JsonIgnoreProperties(ignoreUnknown = true)
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
            @JsonProperty("type")
            val type: CrossMarginTransferType,
            @JsonProperty("transferCounterparty")
            val transferCounterparty: String
        )
}