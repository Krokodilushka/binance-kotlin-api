package com.binance.api.client.domain.general

import com.binance.api.client.domain.FilterType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two forms: symbol filters and exchange filters.
 *
 * The PRICE_FILTER defines the price rules for a symbol.
 *
 * The LOT_SIZE filter defines the quantity (aka "lots" in auction terms) rules for a symbol.
 *
 * The MIN_NOTIONAL filter defines the minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
 *
 * The MAX_NUM_ORDERS filter defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and normal orders are counted for this filter.
 *
 * The MAX_ALGO_ORDERS filter defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class SymbolFilter {
    // PRICE_FILTER
    var filterType: FilterType? = null

    /**
     * Defines the minimum price/stopPrice allowed.
     */
    var minPrice: String? = null

    /**
     * Defines the maximum price/stopPrice allowed.
     */
    var maxPrice: String? = null

    /**
     * Defines the intervals that a price/stopPrice can be increased/decreased by.
     */
    var tickSize: String? = null
    // LOT_SIZE
    /**
     * Defines the minimum quantity/icebergQty allowed.
     */
    var minQty: String? = null

    /**
     * Defines the maximum quantity/icebergQty allowed.
     */
    var maxQty: String? = null

    /**
     * Defines the intervals that a quantity/icebergQty can be increased/decreased by.
     */
    var stepSize: String? = null
    // MIN_NOTIONAL
    /**
     * Defines the minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
     */
    var minNotional: String? = null
    // MAX_NUM_ALGO_ORDERS
    /**
     * Defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders.
     */
    var maxNumAlgoOrders: String? = null
        private set

    /**
     * MAX_NUM_ORDERS filter defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and normal orders are counted for this filter.
     * MAX_ALGO_ORDERS filter defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders.
     * ICEBERG_PARTS filter defines the maximum parts an iceberg order can have. The number of ICEBERG_PARTS is defined as CEIL(qty / icebergQty).
     */
    var limit: String? = null

    fun setMaxNumAlgoOrders(maxNumAlgoOrders: String?): SymbolFilter {
        this.maxNumAlgoOrders = maxNumAlgoOrders
        return this
    }

}