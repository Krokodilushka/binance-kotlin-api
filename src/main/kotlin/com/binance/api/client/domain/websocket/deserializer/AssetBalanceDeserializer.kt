package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.domain.rest.spot.Account
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode

/**
 * Custom deserializer for an AssetBalance, since the streaming API returns an object in the format {"a":"symbol","f":"free","l":"locked"},
 * which is different than the format used in the REST API.
 */
class AssetBalanceDeserializer : JsonDeserializer<Account.Balance>() {

    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): Account.Balance {
        val node = jp.codec.readTree<JsonNode>(jp)
        val asset = node["a"].asText()
        val free = node["f"].asText()
        val locked = node["l"].asText()
        return Account.Balance(asset, free, locked)
    }

}