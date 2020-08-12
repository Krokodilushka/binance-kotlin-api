package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketEvent.MarketEvent.IndividualSymbolMiniTickerEvent.List
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

class IndividualSymbolMiniTickerEventListDeserializer : JsonDeserializer<List>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): List {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        val typeReference = object : TypeReference<kotlin.collections.List<WebSocketEvent.MarketEvent.IndividualSymbolMiniTickerEvent>>() {}
        val list = JsonToObject.convert(json, typeReference)
        return List(list)
    }

}