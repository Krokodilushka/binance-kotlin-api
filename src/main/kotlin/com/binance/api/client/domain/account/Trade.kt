package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Represents an executed trade.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Trade {
    /**
     * Trade id.
     */
    @set:JsonSetter("id")
    var id: Long? = null

    /**
     * Price.
     */
    var price: String? = null

    /**
     * Quantity.
     */
    var qty: String? = null

    /**
     * Quote quantity for the trade (price * qty).
     */
    var quoteQty: String? = null

    /**
     * Commission.
     */
    var commission: String? = null

    /**
     * Asset on which commission is taken
     */
    var commissionAsset: String? = null

    /**
     * Trade execution time.
     */
    var time: Long = 0

    /**
     * The symbol of the trade.
     */
    var symbol: String? = null

    @JsonProperty("isBuyer")
    var isBuyer = false

    @JsonProperty("isMaker")
    var isMaker = false

    @JsonProperty("isBestMatch")
    var isBestMatch = false
    var orderId: String? = null

    @JsonSetter("tradeId")
    fun setTradeId(id: Long?) {
        if (this.id == null) {
            this.id = id
        }
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("symbol", symbol)
                .append("price", price)
                .append("qty", qty)
                .append("quoteQty", quoteQty)
                .append("commission", commission)
                .append("commissionAsset", commissionAsset)
                .append("time", time)
                .append("buyer", isBuyer)
                .append("maker", isMaker)
                .append("bestMatch", isBestMatch)
                .append("orderId", orderId)
                .toString()
    }
}