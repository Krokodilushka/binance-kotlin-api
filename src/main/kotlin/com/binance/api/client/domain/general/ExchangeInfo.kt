package com.binance.api.client.domain.general

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Current exchange trading rules and symbol information.
 * https://github.com/binance-exchange/binance-official-api-docs/blob/master/rest-api.md
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ExchangeInfo {
    var timezone: String? = null
    var serverTime: Long? = null
    var rateLimits: List<RateLimit>? = null

    // private List<String> exchangeFilters;
    var symbols: List<SymbolInfo>? = null

    /**
     * @param symbol the symbol to obtain information for (e.g. ETHBTC)
     * @return symbol exchange information
     */
    fun getSymbolInfo(symbol: String): SymbolInfo {
        return symbols!!.stream().filter { symbolInfo: SymbolInfo -> symbolInfo.symbol == symbol }
                .findFirst()
                .orElseThrow { BinanceApiException("Unable to obtain information for symbol $symbol") }
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("timezone", timezone)
                .append("serverTime", serverTime)
                .append("rateLimits", rateLimits)
                .append("symbols", symbols)
                .toString()
    }
}