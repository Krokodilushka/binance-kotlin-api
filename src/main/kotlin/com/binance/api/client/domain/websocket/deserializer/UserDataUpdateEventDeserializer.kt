package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.event.AccountUpdateEvent
import com.binance.api.client.domain.websocket.event.BalanceUpdateEvent
import com.binance.api.client.domain.websocket.event.OrderTradeUpdateEvent
import com.binance.api.client.domain.websocket.event.UserDataUpdateEvent
import com.binance.api.client.domain.websocket.event.UserDataUpdateEvent.UserDataUpdateEventType
import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.IOException

/**
 * Custom deserializer for a User Data stream event, since the API can return two different responses in this stream.
 *
 * @see UserDataUpdateEvent
 */
class UserDataUpdateEventDeserializer : JsonDeserializer<UserDataUpdateEvent>() {

    private var mapper = ObjectMapper().registerKotlinModule()

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): UserDataUpdateEvent {
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventTypeId = node["e"].asText()
        val eventTime = node["E"].asLong()
        val userDataUpdateEventType: UserDataUpdateEventType = UserDataUpdateEventType.fromEventTypeId(eventTypeId)
        var accountUpdateEvent: AccountUpdateEvent? = null
        var balanceUpdateEvent: BalanceUpdateEvent? = null
        var orderTradeUpdateEvent: OrderTradeUpdateEvent? = null
        when (userDataUpdateEventType) {
            UserDataUpdateEventType.ACCOUNT_UPDATE, UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE -> {
                accountUpdateEvent = getUserDataUpdateEventDetail(json, AccountUpdateEvent::class.java, mapper)
            }
            UserDataUpdateEventType.BALANCE_UPDATE -> {
                balanceUpdateEvent = getUserDataUpdateEventDetail(json, BalanceUpdateEvent::class.java, mapper)
            }
            UserDataUpdateEventType.ORDER_TRADE_UPDATE -> {
                orderTradeUpdateEvent = getUserDataUpdateEventDetail(json, OrderTradeUpdateEvent::class.java, mapper)
            }
        }
        return UserDataUpdateEvent(userDataUpdateEventType, eventTime, accountUpdateEvent, orderTradeUpdateEvent, balanceUpdateEvent)
    }

    private fun <T> getUserDataUpdateEventDetail(json: String?, clazz: Class<T>?, mapper: ObjectMapper): T {
        return try {
            mapper.readValue(json, clazz)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }
}