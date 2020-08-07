package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Account information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Account {
    /**
     * Maker commission.
     */
    var makerCommission = 0

    /**
     * Taker commission.
     */
    var takerCommission = 0

    /**
     * Buyer commission.
     */
    var buyerCommission = 0

    /**
     * Seller commission.
     */
    var sellerCommission = 0

    /**
     * Whether or not this account can trade.
     */
    var isCanTrade = false

    /**
     * Whether or not it is possible to withdraw from this account.
     */
    var isCanWithdraw = false

    /**
     * Whether or not it is possible to deposit into this account.
     */
    var isCanDeposit = false

    /**
     * Last account update time.
     */
    var updateTime: Long = 0

    /**
     * List of asset balances of this account.
     */
    var balances: List<AssetBalance>? = null

    /**
     * Returns the asset balance for a given symbol.
     *
     * @param symbol asset symbol to obtain the balances from
     * @return an asset balance for the given symbol which can be 0 in case the symbol has no balance in the account
     */
    fun getAssetBalance(symbol: String): AssetBalance {
        for (assetBalance in balances!!) {
            if (symbol == assetBalance.asset) {
                return assetBalance
            }
        }
        val emptyBalance = AssetBalance()
        emptyBalance.asset = symbol
        emptyBalance.free = "0"
        emptyBalance.locked = "0"
        return emptyBalance
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("makerCommission", makerCommission)
                .append("takerCommission", takerCommission)
                .append("buyerCommission", buyerCommission)
                .append("sellerCommission", sellerCommission)
                .append("canTrade", isCanTrade)
                .append("canWithdraw", isCanWithdraw)
                .append("canDeposit", isCanDeposit)
                .append("updateTime", updateTime)
                .append("balances", balances)
                .toString()
    }
}