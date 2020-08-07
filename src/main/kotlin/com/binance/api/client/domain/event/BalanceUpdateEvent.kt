package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Account update event which will reflect the current position/balances of the account.
 *
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class BalanceUpdateEvent {
    @JsonProperty("e")
    var eventType: String? = null

    @JsonProperty("E")
    var eventTime: Long = 0

    @JsonProperty("a")
    var asset: String? = null

    @JsonProperty("d")
    var balanceDelta: String? = null

    @JsonProperty("t")
    var clearTime: Long = 0

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("asset", asset)
                .append("balanceDelta", balanceDelta)
                .append("clearTime", clearTime)
                .toString()
    }
}