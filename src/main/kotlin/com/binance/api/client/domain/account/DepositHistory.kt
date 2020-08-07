package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * History of account deposits.
 *
 * @see Deposit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class DepositHistory {
    @JsonProperty("depositList")
    var depositList: List<Deposit>? = null
    var isSuccess = false
    var msg: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("depositList", depositList)
                .append("success", isSuccess)
                .append("msg", msg)
                .toString()
    }
}