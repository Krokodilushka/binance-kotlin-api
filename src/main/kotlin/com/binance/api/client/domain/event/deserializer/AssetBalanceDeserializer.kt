package com.binance.api.client.domain.event.deserializer

import com.binance.api.client.domain.account.AssetBalance
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.io.IOException

/**
 * Custom deserializer for an AssetBalance, since the streaming API returns an object in the format {"a":"symbol","f":"free","l":"locked"},
 * which is different than the format used in the REST API.
 */
class AssetBalanceDeserializer : JsonDeserializer<AssetBalance>() {
    @Throws(IOException::class)
    override fun deserialize(jp: JsonParser, ctx: DeserializationContext): AssetBalance {
        val oc = jp.codec
        val node = oc.readTree<JsonNode>(jp)
        val asset = node["a"].asText()
        val free = node["f"].asText()
        val locked = node["l"].asText()
        val assetBalance = AssetBalance()
        assetBalance.asset = asset
        assetBalance.free = free
        assetBalance.locked = locked
        return assetBalance
    }
}