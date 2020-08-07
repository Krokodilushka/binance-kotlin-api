package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.event.deserializer.UserDataUpdateEventDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.apache.commons.lang3.builder.ToStringBuilder

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
class UserDataUpdateEvent {
    var eventType: UserDataUpdateEventType? = null
    var eventTime: Long = 0
    var accountUpdateEvent: AccountUpdateEvent? = null
    var orderTradeUpdateEvent: OrderTradeUpdateEvent? = null
    var balanceUpdateEvent: BalanceUpdateEvent? = null

    override fun toString(): String {
        val sb = ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
        when (eventType) {
            UserDataUpdateEventType.ACCOUNT_UPDATE -> sb.append("accountUpdateEvent", accountUpdateEvent)
            UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE -> sb.append("accountPositionUpdateEvent", accountUpdateEvent)
            UserDataUpdateEventType.ORDER_TRADE_UPDATE -> sb.append("orderTradeUpdateEvent", orderTradeUpdateEvent)
            else -> sb.append("balanceUpdateEvent", balanceUpdateEvent)
        }
        return sb.toString()
    }

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