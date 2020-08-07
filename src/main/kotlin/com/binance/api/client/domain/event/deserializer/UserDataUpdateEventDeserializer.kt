package com.binance.api.client.domain.event.deserializer

import com.binance.api.client.domain.event.AccountUpdateEvent
import com.binance.api.client.domain.event.BalanceUpdateEvent
import com.binance.api.client.domain.event.OrderTradeUpdateEvent
import com.binance.api.client.domain.event.UserDataUpdateEvent
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType
import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

/**
 * Custom deserializer for a User Data stream event, since the API can return two different responses in this stream.
 *
 * @see UserDataUpdateEvent
 */
class UserDataUpdateEventDeserializer : JsonDeserializer<UserDataUpdateEvent>() {
    private var mapper = ObjectMapper()

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): UserDataUpdateEvent {
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventTypeId = node["e"].asText()
        val eventTime = node["E"].asLong()
        val userDataUpdateEventType: UserDataUpdateEventType = UserDataUpdateEventType.fromEventTypeId(eventTypeId)
        val userDataUpdateEvent = UserDataUpdateEvent()
        userDataUpdateEvent.eventType = userDataUpdateEventType
        userDataUpdateEvent.eventTime = eventTime
        when (userDataUpdateEventType) {
            UserDataUpdateEventType.ACCOUNT_UPDATE, UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE -> {
                userDataUpdateEvent.accountUpdateEvent = getUserDataUpdateEventDetail(json, AccountUpdateEvent::class.java, mapper)
            }
            UserDataUpdateEventType.BALANCE_UPDATE -> {
                userDataUpdateEvent.balanceUpdateEvent = getUserDataUpdateEventDetail(json, BalanceUpdateEvent::class.java, mapper)
            }
            UserDataUpdateEventType.ORDER_TRADE_UPDATE -> {
                userDataUpdateEvent.orderTradeUpdateEvent = getUserDataUpdateEventDetail(json, OrderTradeUpdateEvent::class.java, mapper)
            }
        }
        return userDataUpdateEvent
    }

    private fun <T> getUserDataUpdateEventDetail(json: String?, clazz: Class<T>?, mapper: ObjectMapper): T {
        return try {
            mapper.readValue(json, clazz)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }
}