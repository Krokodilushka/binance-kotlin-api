package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Account information.
 */
@JsonIgnoreProperties
class MarginAccount {
    var isBorrowEnabled = false
    var marginLevel: String? = null
    var totalAssetOfBtc: String? = null
    var totalLiabilityOfBtc: String? = null
    var totalNetAssetOfBtc: String? = null
    var isTradeEnabled = false
    var isTransferEnabled = false
    var userAssets: List<MarginAssetBalance>? = null

    /**
     * Returns the asset balance for a given symbol.
     *
     * @param symbol asset symbol to obtain the balances from
     * @return an asset balance for the given symbol which can be 0 in case the symbol has no balance in the account
     */
    fun getAssetBalance(symbol: String): MarginAssetBalance {
        return userAssets!!.stream()
                .filter { marginAssetBalance: MarginAssetBalance -> marginAssetBalance.asset == symbol }
                .findFirst()
                .orElse(MarginAssetBalance.of(symbol))
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("borrowEnabled", isBorrowEnabled)
                .append("marginLevel", marginLevel)
                .append("totalAssetOfBtc", totalAssetOfBtc)
                .append("totalLiabilityOfBtc", totalLiabilityOfBtc)
                .append("totalNetAssetOfBtc", totalNetAssetOfBtc)
                .append("tradeEnabled", isTradeEnabled)
                .append("transferEnabled", isTransferEnabled)
                .append("userAssets", userAssets)
                .toString()
    }
}