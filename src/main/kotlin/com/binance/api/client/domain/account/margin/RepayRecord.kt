package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class RepayRecord(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
    data class Row(
            @JsonProperty("isolatedSymbol")
            val isolatedSymbol: String?,
            @JsonProperty("amount")
            val amount: String,
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("interest")
            val interest: String,
            @JsonProperty("principal")
            val principal: String,
            @JsonProperty("status")
            val status: String,
            @JsonProperty("timestamp")
            val timestamp: Long,
            @JsonProperty("txId")
            val txId: Long
    )
}