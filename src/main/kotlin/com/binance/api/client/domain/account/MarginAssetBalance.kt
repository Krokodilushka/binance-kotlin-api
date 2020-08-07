package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * An asset balance in an Account.
 *
 * @see Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class MarginAssetBalance {
    /**
     * Asset symbol.
     */
    var asset: String? = null
    var borrowed = "0"

    /**
     * Available balance.
     */
    var free = "0"
    var interest = "0"

    /**
     * Locked by open orders.
     */
    var locked = "0"
    var netAsset = "0"

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("borrowed", borrowed)
                .append("free", free)
                .append("interest", interest)
                .append("locked", locked)
                .append("netAsset", netAsset)
                .toString()
    }

    companion object {
        fun of(asset: String?): MarginAssetBalance {
            val marginAssetBalance = MarginAssetBalance()
            marginAssetBalance.asset = asset
            return marginAssetBalance
        }
    }
}