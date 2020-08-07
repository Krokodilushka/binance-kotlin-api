package com.binance.api.client.domain.general

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Time of the server running Binance's REST API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ServerTime(
        @JsonProperty("serverTime")
        val serverTime: Long
)