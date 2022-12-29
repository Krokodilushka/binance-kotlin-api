package com.binance.api.client.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Included changes at 2020-03-24
 */

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderSide {
    BUY, SELL
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderStatus {
    NEW, PARTIALLY_FILLED, FILLED, CANCELED, PENDING_CANCEL, REJECTED, EXPIRED
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderType {
    LIMIT, MARKET, STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class Permission {
    SPOT, MARGIN, LEVERAGED, TRD_GRP_002, TRD_GRP_003, TRD_GRP_004, TRD_GRP_005, TRD_GRP_006
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderTimeInForce {
    GTC, IOC, FOK
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class TransactionTarget {
    SPOT, ISOLATED_MARGIN
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderRejectReason {
    NONE, UNKNOWN_INSTRUMENT, MARKET_CLOSED, PRICE_QTY_EXCEED_HARD_LIMITS, UNKNOWN_ORDER, DUPLICATE_ORDER, UNKNOWN_ACCOUNT, INSUFFICIENT_BALANCE, ACCOUNT_INACTIVE, ACCOUNT_CANNOT_SETTLE, ORDER_WOULD_TRIGGER_IMMEDIATELY
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class ExecutionType {
    NEW, CANCELED, REPLACED, REJECTED, TRADE, EXPIRED
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class CrossMarginTransferType {
    ROLL_IN, ROLL_OUT
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class RateLimitType {
    REQUEST_WEIGHT, ORDERS, RAW_REQUESTS
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class SymbolStatus {
    PRE_TRADING, TRADING, POST_TRADING, END_OF_DAY, HALT, AUCTION_MATCH, BREAK
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class RateLimitInterval {
    SECOND, MINUTE, DAY
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class SymbolFilterType {
    PRICE_FILTER, LOT_SIZE, MIN_NOTIONAL, MAX_NUM_ORDERS, MAX_NUM_ALGO_ORDERS, ICEBERG_PARTS, PERCENT_PRICE, MARKET_LOT_SIZE, MAX_NUM_ICEBERG_ORDERS, MAX_POSITION, TRAILING_DELTA, PERCENT_PRICE_BY_SIDE
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class ExchangeFilterType {
    EXCHANGE_MAX_NUM_ORDERS, EXCHANGE_MAX_ALGO_ORDERS
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class CandlestickInterval(val intervalId: String) {
    ONE_MINUTE("1m"),
    THREE_MINUTES("3m"),
    FIVE_MINUTES("5m"),
    FIFTEEN_MINUTES("15m"),
    HALF_HOURLY("30m"),
    HOURLY("1h"),
    TWO_HOURLY("2h"),
    FOUR_HOURLY("4h"),
    SIX_HOURLY("6h"),
    EIGHT_HOURLY("8h"),
    TWELVE_HOURLY("12h"),
    DAILY("1d"),
    THREE_DAILY("3d"),
    WEEKLY("1w"),
    MONTHLY("1M")
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class NewOrderResponseType {
    ACK, RESULT, FULL

}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OcoStatus {
    RESPONSE, EXEC_STARTED, ALL_DONE
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OcoOrderStatus {
    EXECUTING, ALL_DONE, REJECT
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class OrderSideEffectType {
    NO_SIDE_EFFECT, MARGIN_BUY, AUTO_REPAY
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class MarginLevelStatus {
    EXCESSIVE, NORMAL, MARGIN_CALL, PRE_LIQUIDATION, FORCE_LIQUIDATION
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class ContingencyType {
    OCO
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class ListStatusType {
    RESPONSE, EXEC_STARTED, ALL_DONE
}

@JsonIgnoreProperties(ignoreUnknown = true)
enum class ListOrderStatus {
    EXECUTING, ALL_DONE, REJECT
}
