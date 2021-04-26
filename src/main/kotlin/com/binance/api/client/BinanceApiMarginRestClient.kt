package com.binance.api.client

import com.binance.api.client.domain.*
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceMargin

class BinanceApiMarginRestClient(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) {

    private val binanceApiServiceMargin =
        BinanceApiServiceGenerator.createService(BinanceApiServiceMargin::class.java, apiKey, secret, baseUrl)

    /**
     * Execute transfer between spot account and cross margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cross-margin-account-transfer-margin
     */
    fun newCrossTransfer(asset: String, amount: String, type: Short) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.newCrossTransfer(
                asset,
                amount,
                type,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Apply for a loan.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-borrow-margin
     */
    fun newLoan(asset: String, isIsolated: Boolean?, symbol: String?, amount: String) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.newLoan(
                asset,
                isIsolated,
                symbol,
                amount,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Repay loan for margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-repay-margin
     */
    fun newRepay(asset: String, isIsolated: Boolean?, symbol: String?, amount: String) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.newRepay(
                asset,
                isIsolated,
                symbol,
                amount,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-asset-market_data
     */
    fun asset(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.asset(symbol))

    /**
     *
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-pair-market_data
     */
    fun pair(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.pair(symbol))

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-assets-market_data
     */
    fun allAssets() =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.allAssets())

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-pairs-market_data
     */
    fun allPairs() =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.allPairs())

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-priceindex-market_data
     */
    fun priceIndex(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.priceIndex(symbol))

    /**
     * Post a new order for margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-new-order-trade
     */
    fun newOrder(
        symbol: String,
        isIsolated: Boolean?,
        side: OrderSide,
        type: OrderType,
        quantity: String,
        price: String?,
        stopPrice: String?,
        icebergQty: String?,
        newClientOrderId: String?,
        sideEffectType: OrderSideEffectType?,
        timeInForce: OrderTimeInForce?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.newOrder(
            symbol,
            isIsolated,
            side,
            type,
            quantity,
            null,
            price,
            stopPrice,
            icebergQty,
            newClientOrderId,
            NewOrderResponseType.FULL,
            sideEffectType,
            timeInForce,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Cancel an active order for margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-order-trade
     */
    fun cancelOrder(
        symbol: String,
        isIsolated: Boolean?,
        orderId: Long?,
        origClientOrderId: String?,
        newClientOrderId: String?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.cancelOrder(
            symbol,
            isIsolated,
            orderId,
            origClientOrderId,
            newClientOrderId,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Cancels all active orders on a symbol for margin account.
     * This includes OCO orders.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-all-open-orders-on-a-symbol-trade
     */
    fun cancelOpenOrders(
        symbol: String,
        isIsolated: Boolean?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.cancelOpenOrders(
            symbol,
            isIsolated,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-cross-margin-transfer-history-user_data
     */
    fun crossTransfer(
        asset: String?,
        type: CrossMarginTransferType?,
        startTime: String?,
        endTime: String?,
        current: String?,
        size: String?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.crossTransfer(
            asset,
            type,
            startTime,
            endTime,
            current,
            size,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-loan-record-user_data
     */
    fun loan(
        asset: String,
        isolatedSymbol: String?,
        txId: Long?,
        startTime: Long?,
        endTime: Long?,
        current: Long?,
        size: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.loan(
            asset,
            isolatedSymbol,
            txId,
            startTime,
            endTime,
            current,
            size,
            null,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-repay-record-user_data
     */
    fun repay(
        asset: String,
        isolatedSymbol: Boolean?,
        txId: Long?,
        startTime: Long?,
        endTime: Long?,
        current: Long?,
        size: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.repay(
            asset,
            isolatedSymbol,
            txId,
            startTime,
            endTime,
            current,
            size,
            null,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-interest-history-user_data
     */
    fun interestHistory(
        asset: String?,
        isolatedSymbol: String?,
        startTime: Long?,
        endTime: Long?,
        current: Long?,
        size: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.interestHistory(
            asset,
            isolatedSymbol,
            startTime,
            endTime,
            current,
            size,
            null,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-force-liquidation-record-user_data
     */
    fun forceLiquidationRec(
        startTime: Long?,
        endTime: Long?,
        isolatedSymbol: Boolean?,
        current: Long?,
        size: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.forceLiquidationRec(
            startTime,
            endTime,
            isolatedSymbol,
            current,
            size,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-account-details-user_data
     */
    fun account() = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.account(
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-order-user_data
     */
    fun order(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.order(
                symbol,
                isIsolated,
                orderId,
                origClientOrderId,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-order-user_data
     */
    fun openOrders(symbol: String?, isIsolated: Boolean?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.openOrders(
                symbol,
                isIsolated,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-all-order-user_data
     */
    fun allOrders(
        symbol: String,
        isIsolated: Boolean?,
        orderId: Long?,
        startTime: Long?,
        endTime: Long?,
        limit: Int?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.allOrders(
            symbol,
            isIsolated,
            orderId,
            startTime,
            endTime,
            limit,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-trade-list-user_data
     */
    fun myTrades(
        symbol: String,
        isIsolated: Boolean?,
        startTime: Long?,
        endTime: Long?,
        fromId: Long?,
        limit: Int?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.myTrades(
            symbol,
            isIsolated,
            startTime,
            endTime,
            fromId,
            limit,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-max-borrow-user_data
     */
    fun maxBorrowable(asset: String, isolatedSymbol: String?) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.maxBorrowable(
            asset,
            isolatedSymbol,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-max-transfer-out-amount-user_data
     */
    fun maxTransferable(asset: String, isolatedSymbol: String?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.maxTransferable(
                asset,
                isolatedSymbol,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#create-isolated-margin-account-margin
     */
    fun isolatedCreate(base: String, quote: String) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.isolatedCreate(
                base,
                quote,
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#isolated-margin-account-transfer-margin
     */
    fun newIsolatedTransfer(
        asset: String,
        symbol: String,
        transFrom: TransactionTarget,
        transTo: TransactionTarget,
        amount: String
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.newIsolatedTransfer(
            asset,
            symbol,
            transFrom,
            transTo,
            amount,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-isolated-margin-transfer-history-user_data
     */
    fun isolatedTransfer(
        asset: String?,
        symbol: String,
        transFrom: TransactionTarget?,
        transTo: TransactionTarget?,
        startTime: Long?,
        endTime: Long?,
        current: Long?,
        size: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.isolatedTransfer(
            asset,
            symbol,
            transFrom,
            transTo,
            startTime,
            endTime,
            current,
            size,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount() = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.isolatedAccount(
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount(symbols: List<String>) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiServiceMargin.isolatedAccount(
                symbols.joinToString(",") { it },
                BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-symbol-user_data
     */
    fun isolatedPair(symbol: String) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.isolatedPair(
            symbol,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-isolated-margin-symbol-user_data
     */
    fun isolatedAllPairs() = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.isolatedAllPairs(
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#toggle-bnb-burn-on-spot-trade-and-margin-interest-user_data
     */
    fun bnbBurn(spotBNBBurn: Boolean, interestBNBBurn: Boolean) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.bnbBurn(
            spotBNBBurn,
            interestBNBBurn,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-bnb-burn-status-user_data
     */
    fun bnbBurn() = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.bnbBurn(
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-interest-rate-history-user_data
     */
    fun interestRateHistory(
        asset: String,
        vipLevel: String?,
        startTime: String?,
        endTime: String?,
        limit: Int?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiServiceMargin.interestRateHistory(
            asset,
            vipLevel,
            startTime,
            endTime,
            limit,
            BinanceApiConstants.MARGIN_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun startMarginUserDataStream() =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.startMarginUserDataStream())

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun keepAliveMarginUserDataStream(listenKey: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.keepAliveMarginUserDataStream(listenKey))

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun deleteMarginUserDataStream(listenKey: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.closeMarginUserDataStream(listenKey))

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun startIsolatedMarginUserDataStream(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.startIsolatedMarginUserDataStream(symbol))

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun keepAliveIsolatedMarginUserDataStream(listenKey: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.keepAliveIsolatedMarginUserDataStream(listenKey))

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun deleteIsolatedMarginUserDataStream(listenKey: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.closeIsolatedMarginUserDataStream(listenKey))

}