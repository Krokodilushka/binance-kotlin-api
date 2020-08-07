package com.binance.api.client.domain.general

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * An asset Binance supports.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Asset {
    @JsonProperty("id")
    val id: String? = null

    @JsonProperty("assetCode")
    val assetCode: String? = null

    @JsonProperty("assetName")
    val assetName: String? = null

    @JsonProperty("unit")
    val unit: String? = null

    @JsonProperty("transactionFee")
    val transactionFee: String? = null

    @JsonProperty("commissionRate")
    val commissionRate: String? = null

    @JsonProperty("freeAuditWithdrawAmt")
    val freeAuditWithdrawAmount: String? = null

    @JsonProperty("freeUserChargeAmount")
    val freeUserChargeAmount: String? = null

    @JsonProperty("minProductWithdraw")
    private val minProductWithdraw: String? = null

    @JsonProperty("withdrawIntegerMultiple")
    val withdrawIntegerMultiple: String? = null

    @JsonProperty("confirmTimes")
    val confirmTimes: Long = 0

    @JsonProperty("enableWithdraw")
    private val enableWithdraw = false

    @JsonProperty("isLegalMoney")
    val isLegalMoney = false

    fun minProductWithdraw(): String? {
        return minProductWithdraw
    }

    fun canWithraw(): Boolean {
        return enableWithdraw
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("assetCode", assetCode)
                .append("assetName", assetName)
                .append("unit", unit)
                .append("transactionFee", transactionFee)
                .append("commissionRate", commissionRate)
                .append("freeAuditWithdrawAmount", freeAuditWithdrawAmount)
                .append("freeUserChargeAmount", freeUserChargeAmount)
                .append("minProductWithdraw", minProductWithdraw)
                .append("withdrawIntegerMultiple", withdrawIntegerMultiple)
                .append("confirmTimes", confirmTimes)
                .append("enableWithdraw", enableWithdraw)
                .append("isLegalMoney", isLegalMoney)
                .toString()
    }
}