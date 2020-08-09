package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class RepayRecord(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
        @JsonIgnoreProperties(ignoreUnknown = true)
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