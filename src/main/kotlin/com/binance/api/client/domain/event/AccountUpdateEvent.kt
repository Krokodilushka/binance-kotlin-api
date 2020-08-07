package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.account.AssetBalance
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Account update event which will reflect the current position/balances of the account.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AccountUpdateEvent {
    @JsonProperty("e")
    var eventType: String? = null

    @JsonProperty("E")
    var eventTime: Long = 0

    @JsonProperty("B")
    @JsonDeserialize(contentUsing = AssetBalanceDeserializer::class)
    var balances: List<AssetBalance>? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("balances", balances)
                .toString()
    }
}