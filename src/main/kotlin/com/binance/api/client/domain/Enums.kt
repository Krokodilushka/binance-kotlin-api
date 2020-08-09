package com.binance.api.client.domain

enum class OrderSide {
    BUY, SELL
}

enum class OrderStatus {
    NEW, PARTIALLY_FILLED, FILLED, CANCELED, PENDING_CANCEL, REJECTED, EXPIRED
}

enum class OrderType {
    LIMIT, MARKET, STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
}

enum class Permission {
    SPOT, MARGIN, LEVERAGED
}

enum class OrderTimeInForce {
    GTC, IOC, FOK
}

enum class TransactionTarget {
    SPOT, ISOLATED_MARGIN
}

enum class OrderRejectReason {
    NONE, UNKNOWN_INSTRUMENT, MARKET_CLOSED, PRICE_QTY_EXCEED_HARD_LIMITS, UNKNOWN_ORDER, DUPLICATE_ORDER, UNKNOWN_ACCOUNT, INSUFFICIENT_BALANCE, ACCOUNT_INACTIVE, ACCOUNT_CANNOT_SETTLE, ORDER_WOULD_TRIGGER_IMMEDIATELY
}

enum class ExecutionType {
    NEW, CANCELED, REPLACED, REJECTED, TRADE, EXPIRED
}

enum class TransferType {
    ROLL_IN, ROLL_OUT
}

enum class RateLimitType {
    REQUEST_WEIGHT, ORDERS
}

enum class SymbolStatus {
    PRE_TRADING, TRADING, POST_TRADING, END_OF_DAY, HALT, AUCTION_MATCH, BREAK
}

enum class RateLimitInterval {
    SECOND, MINUTE, DAY
}

enum class SymbolFilterType {
    PRICE_FILTER, LOT_SIZE, MIN_NOTIONAL, MAX_NUM_ORDERS, MAX_NUM_ALGO_ORDERS, ICEBERG_PARTS, PERCENT_PRICE, MARKET_LOT_SIZE, MAX_NUM_ICEBERG_ORDERS, MAX_POSITION
}

enum class ExchangeFilterType {
    EXCHANGE_MAX_NUM_ORDERS, EXCHANGE_MAX_ALGO_ORDERS
}

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

enum class NewOrderResponseType {
    ACK, RESULT, FULL

}

enum class OcoStatus {
    RESPONSE, EXEC_STARTED, ALL_DONE
}

enum class OcoOrderStatus {
    EXECUTING, ALL_DONE, REJECT
}

enum class OrderSideEffectType {
    NO_SIDE_EFFECT, MARGIN_BUY, AUTO_REPAY
}
