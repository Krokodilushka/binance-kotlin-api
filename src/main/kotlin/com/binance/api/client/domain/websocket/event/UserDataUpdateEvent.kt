package com.binance.api.client.domain.websocket.event

import com.binance.api.client.domain.websocket.deserializer.UserDataUpdateEventDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * User data update event which can be of two types:
 *
 *
 * 1) outboundAccountInfo, whenever there is a change in the account (e.g. balance of an asset)
 * 2) outboundAccountPosition, the change in account balances caused by an event.
 * 3) executionReport, whenever there is a trade or an order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer::class)
data class UserDataUpdateEvent(
        val eventType: UserDataUpdateEventType,
        val eventTime: Long,
        val accountUpdateEvent: AccountUpdateEvent?,
        val orderTradeUpdateEvent: OrderTradeUpdateEvent?,
        val balanceUpdateEvent: BalanceUpdateEvent?
) {
    enum class UserDataUpdateEventType(val eventTypeId: String) {
        ACCOUNT_UPDATE("outboundAccountInfo"), ACCOUNT_POSITION_UPDATE("outboundAccountPosition"), ORDER_TRADE_UPDATE("executionReport"), BALANCE_UPDATE("balanceUpdate");

        companion object {
            fun fromEventTypeId(eventTypeId: String) = when (eventTypeId) {
                ACCOUNT_UPDATE.eventTypeId -> ACCOUNT_UPDATE
                ORDER_TRADE_UPDATE.eventTypeId -> ORDER_TRADE_UPDATE
                ACCOUNT_POSITION_UPDATE.eventTypeId -> ACCOUNT_POSITION_UPDATE
                BALANCE_UPDATE.eventTypeId -> BALANCE_UPDATE
                else -> throw IllegalArgumentException("Unrecognized user data update event type id: $eventTypeId")
            }
        }
    }
}