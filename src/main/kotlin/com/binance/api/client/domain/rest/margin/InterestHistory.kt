package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class InterestHistory(
        @JsonProperty("rows")
        val rows: List<Row>,
        @JsonProperty("total")
        val total: Long
) {
    data class Row(
            @JsonProperty("isolatedSymbol")
            val isolatedSymbol: String,
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("interest")
            val interest: String,
            @JsonProperty("interestAccuredTime")
            val interestAccuredTime: Long,
            @JsonProperty("interestRate")
            val interestRate: String,
            @JsonProperty("principal")
            val principal: String,
            @JsonProperty("type")
            val type: String
    )
}