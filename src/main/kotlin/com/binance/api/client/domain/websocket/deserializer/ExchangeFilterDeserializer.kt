package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.ExchangeFilterType
import com.binance.api.client.domain.rest.ExchangeFilter
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


/**
 * Custom deserializer for a User Data stream event, since the API can return two different responses in this stream.
 *
 * @see UserDataUpdateEvent
 */
class ExchangeFilterDeserializer : JsonDeserializer<ExchangeFilter>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): ExchangeFilter {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        return when (ExchangeFilterType.valueOf(node["filterType"].asText())) {
            ExchangeFilterType.EXCHANGE_MAX_NUM_ORDERS -> JsonToObject.convert(json, ExchangeFilter.ExchangeMaxNumOrders::class.java)
            ExchangeFilterType.EXCHANGE_MAX_ALGO_ORDERS -> JsonToObject.convert(json, ExchangeFilter.ExchangeMaxAlgoOrders::class.java)
        }
    }

}