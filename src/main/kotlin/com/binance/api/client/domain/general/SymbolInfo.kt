package com.binance.api.client.domain.general

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.OrderType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Symbol information (base/quote).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class SymbolInfo {
    var symbol: String? = null
    var status: SymbolStatus? = null
    var baseAsset: String? = null
    var baseAssetPrecision: Int? = null
    var quoteAsset: String? = null
    var quotePrecision: Int? = null
    var orderTypes: List<OrderType>? = null
    var isIcebergAllowed = false
    var filters: List<SymbolFilter>? = null

    /**
     * @param filterType filter type to filter for.
     * @return symbol filter information for the provided filter type.
     */
    fun getSymbolFilter(filterType: FilterType): SymbolFilter {
        return filters!!.stream()
                .filter { symbolFilter: SymbolFilter -> symbolFilter.filterType == filterType }
                .findFirst()
                .get()
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("status", status)
                .append("baseAsset", baseAsset)
                .append("baseAssetPrecision", baseAssetPrecision)
                .append("quoteAsset", quoteAsset)
                .append("quotePrecision", quotePrecision)
                .append("orderTypes", orderTypes)
                .append("icebergAllowed", isIcebergAllowed)
                .append("filters", filters)
                .toString()
    }
}