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
class MaxBorrowable {
    var amount: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("amount", amount)
                .toString()
    }
}