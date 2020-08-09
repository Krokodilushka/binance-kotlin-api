package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LoanRecord(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Row(
            @JsonProperty("isolatedSymbol")
            val isolatedSymbol: String?,
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("principal")
            val principal: String,
            @JsonProperty("timestamp")
            val timestamp: Long,
            @JsonProperty("status")
            val status: String,
            @JsonProperty("txId")
            val txId: Long
    )
}