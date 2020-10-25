package com.binance.api.client

import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.Amount
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.Transaction
import com.binance.api.client.domain.rest.margin.*

interface BinanceApiMarginRestClient {

    /**
     * Execute transfer between spot account and cross margin account.
     * @see https://binance-docs.github.io/apidocs/spot/en/#cross-margin-account-transfer-margin
     */
    fun newCrossTransfer(asset: String, amount: String, type: Short): Transaction

    /**
     * Apply for a loan.
     * @see https://binance-docs.github.io/apidocs/spot/en/#margin-account-borrow-margin
     */
    fun newLoan(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Transaction

    /**
     * Repay loan for margin account.
     * @see https://binance-docs.github.io/apidocs/spot/en/#margin-account-repay-margin
     */
    fun newRepay(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Transaction

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-asset-market_data
     */
    fun asset(symbol: String): CrossMarginAsset

    /**
     *
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-pair-market_data
     */
    fun pair(symbol: String): MarginPair

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-assets-market_data
     */
    fun allAssets(): List<CrossMarginAsset>

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-pairs-market_data
     */
    fun allPairs(): List<MarginPair>

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-priceindex-market_data
     */
    fun priceIndex(symbol: String): PriceIndex

    /**
     * Post a new order for margin account.
     * @see https://binance-docs.github.io/apidocs/spot/en/#margin-account-new-order-trade
     */
    fun newOrder(symbol: String, isIsolated: Boolean?, side: OrderSide, type: OrderType, quantity: String, price: String?, stopPrice: String?, icebergQty: String?, newClientOrderId: String?, sideEffectType: OrderSideEffectType?, timeInForce: OrderTimeInForce?): NewOrder

    /**
     * Cancel an active order for margin account.
     * @see https://binance-docs.github.io/apidocs/spot/en/#margin-account-cancel-order-trade
     */
    fun cancelOrder(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?, newClientOrderId: String?): CancelOrder

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-cross-margin-transfer-history-user_data
     */
    fun crossTransfer(asset: String?, type: TransferType?, startTime: String?, endTime: String?, current: String?, size: String?): TransferHistory

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-loan-record-user_data
     */
    fun loan(asset: String, isolatedSymbol: String?, txId: Long?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): LoanRecord

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-repay-record-user_data
     */
    fun repay(asset: String, isolatedSymbol: Boolean?, txId: Long?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): RepayRecord

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-interest-history-user_data
     */
    fun interestHistory(asset: String?, isolatedSymbol: String?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): InterestHistory

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-force-liquidation-record-user_data
     */
    fun forceLiquidationRec(startTime: Long?, endTime: Long?, isolatedSymbol: Boolean?, current: Long?, size: Long?): ForceLiquidationRecord

    /**
     *
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-account-details-user_data
     */
    fun account(): Account

    /**
     *
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-order-user_data
     */
    fun order(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?): Order

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-order-user_data
     */
    fun openOrders(symbol: String?, isIsolated: Boolean?): List<Order>

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-all-order-user_data
     */
    fun allOrders(symbol: String, isIsolated: Boolean?, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?): List<Order>

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-trade-list-user_data
     */
    fun myTrades(symbol: String, isIsolated: Boolean?, startTime: Long?, endTime: Long?, fromId: Long?, limit: Int?): List<com.binance.api.client.domain.rest.margin.Trade>

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-max-borrow-user_data
     */
    fun maxBorrowable(asset: String, isolatedSymbol: String?): Amount

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-max-transfer-out-amount-user_data
     */
    fun maxTransferable(asset: String, isolatedSymbol: String?): Amount

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#create-isolated-margin-account-margin
     */
    fun isolatedCreate(base: String, quote: String): CreateIsolatedAccount

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#isolated-margin-account-transfer-margin
     */
    fun newIsolatedTransfer(asset: String, symbol: String, transFrom: TransactionTarget, transTo: TransactionTarget, amount: String): Transaction

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-isolated-margin-transfer-history-user_data
     */
    fun isolatedTransfer(asset: String?, symbol: String, transFrom: TransactionTarget?, transTo: TransactionTarget?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): IsolatedTransferHistory

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount(): IsolatedAccountInfo

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount(symbols: List<String>): IsolatedAccountInfo.IsolatedAccountInfoSymbols

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-symbol-user_data
     */
    fun isolatedPair(symbol: String): IsolatedPair

    /**
     * @see https://binance-docs.github.io/apidocs/spot/en/#get-all-isolated-margin-symbol-user_data
     */
    fun isolatedAllPairs(): List<IsolatedPair>

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun startMarginUserDataStream(): String

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun keepAliveMarginUserDataStream(listenKey: String): Empty

    /**
     * Close out a user data stream.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun deleteMarginUserDataStream(listenKey: String): Empty

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun startIsolatedMarginUserDataStream(symbol: String): String

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun keepAliveIsolatedMarginUserDataStream(listenKey: String): Empty

    /**
     * Close out a user data stream.
     * @see https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun deleteIsolatedMarginUserDataStream(listenKey: String): Empty
}