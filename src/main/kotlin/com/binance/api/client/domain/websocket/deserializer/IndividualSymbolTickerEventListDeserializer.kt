package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketEvent.MarketEvent.IndividualSymbolTickerEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

class IndividualSymbolTickerEventListDeserializer : JsonDeserializer<IndividualSymbolTickerEvent.List>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): IndividualSymbolTickerEvent.List {
        val node = jp.codec.readTree<JsonNode>(jp)
        val json = node.toString()
        val typeReference = object : TypeReference<List<IndividualSymbolTickerEvent>>() {}
        val list = JsonToObject.convert(json, typeReference)
        return IndividualSymbolTickerEvent.List(list)
    }

}