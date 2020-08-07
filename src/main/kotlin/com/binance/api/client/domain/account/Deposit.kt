package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A deposit that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Deposit {
    /**
     * Amount deposited.
     */
    var amount: String? = null

    /**
     * Symbol.
     */
    var asset: String? = null

    /**
     * Deposit time.
     */
    var insertTime: String? = null

    /**
     * Transaction id
     */
    var txId: String? = null

    /**
     * (0:pending,1:success)
     */
    var status = 0

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("amount", amount)
                .append("asset", asset)
                .append("insertTime", insertTime)
                .append("txId", txId)
                .append("status", status)
                .toString()
    }
}