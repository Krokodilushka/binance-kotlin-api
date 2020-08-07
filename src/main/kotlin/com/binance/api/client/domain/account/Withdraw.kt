package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A withdraw that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Withdraw {
    /**
     * Amount withdrawn.
     */
    var amount: String? = null

    /**
     * Destination address.
     */
    var address: String? = null

    /**
     * Symbol.
     */
    var asset: String? = null
    var applyTime: String? = null
    var successTime: String? = null

    /**
     * Transaction id.
     */
    var txId: String? = null

    /**
     * Id.
     */
    var id: String? = null

    /**
     * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
     */
    var status = 0

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("amount", amount)
                .append("address", address)
                .append("asset", asset)
                .append("applyTime", applyTime)
                .append("successTime", successTime)
                .append("txId", txId)
                .append("id", id)
                .append("status", status)
                .toString()
    }
}