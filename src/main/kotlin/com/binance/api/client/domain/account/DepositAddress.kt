package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A deposit address for a given asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class DepositAddress {
    var address: String? = null
    var isSuccess = false
    var addressTag: String? = null
    var asset: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("address", address)
                .append("success", isSuccess)
                .append("addressTag", addressTag)
                .append("asset", asset)
                .toString()
    }
}