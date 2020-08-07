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
class AssetBalance {
    /**
     * Asset symbol.
     */
    var asset: String? = null

    /**
     * Available balance.
     */
    var free: String? = null

    /**
     * Locked by open orders.
     */
    var locked: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("free", free)
                .append("locked", locked)
                .toString()
    }
}