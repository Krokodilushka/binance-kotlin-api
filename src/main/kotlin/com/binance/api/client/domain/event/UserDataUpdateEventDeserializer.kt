package com.binance.api.client.domain.event

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
    private var mapper: ObjectMapper? = null

    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): UserDataUpdateEvent {
        if (mapper == null) {
            mapper = ObjectMapper()
        }
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val json = node.toString()
        val eventTypeId = node["e"].asText()
        val eventTime = node["E"].asLong()
        val userDataUpdateEventType: UserDataUpdateEventType = UserDataUpdateEventType.fromEventTypeId(eventTypeId)
        val userDataUpdateEvent = UserDataUpdateEvent()
        userDataUpdateEvent.eventType = userDataUpdateEventType
        userDataUpdateEvent.eventTime = eventTime
        if (userDataUpdateEventType == UserDataUpdateEventType.ACCOUNT_UPDATE ||
                userDataUpdateEventType == UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE) {
            val accountUpdateEvent = getUserDataUpdateEventDetail(json, AccountUpdateEvent::class.java, mapper!!)
            userDataUpdateEvent.accountUpdateEvent = accountUpdateEvent
        } else if (userDataUpdateEventType == UserDataUpdateEventType.BALANCE_UPDATE) {
            val balanceUpdateEvent = getUserDataUpdateEventDetail(json, BalanceUpdateEvent::class.java, mapper!!)
            userDataUpdateEvent.balanceUpdateEvent = balanceUpdateEvent
        } else { // userDataUpdateEventType == UserDataUpdateEventType.ORDER_TRADE_UPDATE
            val orderTradeUpdateEvent = getUserDataUpdateEventDetail(json, OrderTradeUpdateEvent::class.java, mapper!!)
            userDataUpdateEvent.orderTradeUpdateEvent = orderTradeUpdateEvent
        }
        return userDataUpdateEvent
    }

    fun <T> getUserDataUpdateEventDetail(json: String?, clazz: Class<T>?, mapper: ObjectMapper): T {
        return try {
            mapper.readValue(json, clazz)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }
}