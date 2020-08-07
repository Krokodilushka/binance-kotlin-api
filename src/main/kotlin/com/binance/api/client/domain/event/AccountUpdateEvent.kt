package com.binance.api.client.domain.event

import com.binance.api.client.domain.Permission
import com.binance.api.client.domain.account.AssetBalance
import com.binance.api.client.domain.event.deserializer.AssetBalanceDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * Account update event which will reflect the current position/balances of the account.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountUpdateEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,

        @JsonProperty("m")
        val makerCommissionRate: Long? = null,
        @JsonProperty("t")
        val takerCommissionRate: Long? = null,
        @JsonProperty("b")
        val buyerCommissionRate: Long? = null,
        @JsonProperty("s")
        val sellerCommissionRate: Long? = null,
        @JsonProperty("T")
        val canTrade: Boolean? = null,
        @JsonProperty("W")
        val canWithdraw: Boolean? = null,
        @JsonProperty("D")
        val canDeposit: Boolean? = null,
        @JsonProperty("u")
        val timeOfLastAccountUpdate: Long? = null,

        @JsonProperty("B")
        @JsonDeserialize(contentUsing = AssetBalanceDeserializer::class)
        val balances: List<AssetBalance>,

        @JsonProperty("P")
        val permissions: List<Permission>? = null
)