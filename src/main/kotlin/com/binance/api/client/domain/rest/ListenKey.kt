package com.binance.api.client.domain.rest

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Dummy type to wrap a listen key from a server response.
 */
data class ListenKey(
        @JsonProperty("listenKey")
        val listenKey: String
)