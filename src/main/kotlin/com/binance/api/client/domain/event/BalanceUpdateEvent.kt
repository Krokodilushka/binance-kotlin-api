package com.binance.api.client.domain.event

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Account update event which will reflect the current position/balances of the account.
 *
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class BalanceUpdateEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,
        @JsonProperty("a")
        val asset: String,
        @JsonProperty("d")
        val balanceDelta: String,
        @JsonProperty("T")
        val clearTime: Long
)