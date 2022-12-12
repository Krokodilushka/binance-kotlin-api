package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.websocket.WebSocketEvent
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


class WebSocketEventWrapperDeserializer : JsonDeserializer<WebSocketEvent.WebSocketEventSealed>() {
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): WebSocketEvent.WebSocketEventSealed? {
        val node = jp.codec.readTree<JsonNode>(jp)
        if (null !== node["stream"] && null !== node["data"]) {
            val stream = node["stream"].textValue()
            val eventType = node["data"]["e"]?.textValue()
            val json = node["data"].toString()
            val event = when {
                // market data
                stream.endsWith("@aggTrade") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.AggTradeEvent::class.java)
                stream.endsWith("@trade") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.TradeEvent::class.java)
                stream.contains("@kline_") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.CandlestickEvent::class.java)
                stream.endsWith("@miniTicker") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.IndividualSymbolMiniTickerEvent::class.java)
                stream == "!miniTicker@arr" -> JsonToObject.convert(json, object : TypeReference<WebSocketEvent.MarketEvent.IndividualSymbolMiniTickerEvent.List>() {})
                stream.endsWith("@ticker") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.IndividualSymbolTickerEvent::class.java)
                stream == "!ticker@arr" -> JsonToObject.convert(json, object : TypeReference<WebSocketEvent.MarketEvent.IndividualSymbolTickerEvent.List>() {})
                stream.endsWith("@bookTicker") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.IndividualSymbolBookTickerEvent::class.java)
                stream == "!bookTicker" -> JsonToObject.convert(json, object : TypeReference<WebSocketEvent.MarketEvent.IndividualSymbolBookTickerEvent>() {})
                stream.contains("@depth[0-9]+".toRegex()) -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.PartialBookDepth::class.java)
                stream.contains("@depth") -> JsonToObject.convert(json, WebSocketEvent.MarketEvent.DepthEvent::class.java)
                // user events
                else -> when (eventType) {
                    "outboundAccountPosition" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.AccountPosition::class.java)
                    "balanceUpdate" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.BalanceUpdateEvent::class.java)
                    "executionReport" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.OrderTradeUpdateEvent::class.java)
                    "listStatus" -> JsonToObject.convert(json, WebSocketEvent.UserDataEvent.Event.OcoOrderTradeUpdateEvent::class.java)
                    else -> return null
                }
            }
            return WebSocketEvent.WebSocketEventSealed.Event(stream, event)
        }else if (null !== node["id"]){
            return WebSocketEvent.WebSocketEventSealed.MessageResult(node["result"].textValue(),  node["id"].intValue())
        }
        return null
    }
}