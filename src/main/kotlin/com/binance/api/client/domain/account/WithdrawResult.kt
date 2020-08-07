package com.binance.api.client.domain.account

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle

/**
 * A withdraw result that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class WithdrawResult {
    /**
     * Withdraw message.
     */
    var msg: String? = null

    /**
     * Withdraw success.
     */
    var isSuccess = false

    /**
     * Withdraw id.
     */
    var id: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("msg", msg)
                .append("success", isSuccess)
                .append("id", id)
                .toString()
    }
}