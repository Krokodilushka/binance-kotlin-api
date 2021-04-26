package com.binance.api.client

import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.Amount
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.ListenKey
import com.binance.api.client.domain.rest.Transaction
import com.binance.api.client.domain.rest.margin.*
import retrofit2.Response

interface BinanceApiMarginRestClient {

    /**
     * Execute transfer between spot account and cross margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cross-margin-account-transfer-margin
     */
    fun newCrossTransfer(asset: String, amount: String, type: Short): Response<Transaction>

    /**
     * Apply for a loan.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-borrow-margin
     */
    fun newLoan(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Response<Transaction>

    /**
     * Repay loan for margin account.
     * @link https://binance-docs.github.io/apidocs/spot/en/#margin-account-repay-margin
     */
    fun newRepay(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Response<Transaction>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-asset-market_data
     */
    fun asset(symbol: String): Response<CrossMarginAsset>

    /**
     *
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-pair-market_data
     */
    fun pair(symbol: String): Response<MarginPair>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-assets-market_data
     */
    fun allAssets(): Response<List<CrossMarginAsset>>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-cross-margin-pairs-market_data
     */
    fun allPairs(): Response<List<MarginPair>>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-priceindex-market_data
     */
    fun priceIndex(symbol: String): Response<PriceIndex>

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
    ): Response<NewOrder>

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
    ): Response<CancelOrder>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-cross-margin-transfer-history-user_data
     */
    fun crossTransfer(
        asset: String?,
        type: TransferType?,
        startTime: String?,
        endTime: String?,
        current: String?,
        size: String?
    ): Response<TransferHistory>

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
    ): Response<LoanRecord>

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
    ): Response<RepayRecord>

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
    ): Response<InterestHistory>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-force-liquidation-record-user_data
     */
    fun forceLiquidationRec(
        startTime: Long?,
        endTime: Long?,
        isolatedSymbol: Boolean?,
        current: Long?,
        size: Long?
    ): Response<ForceLiquidationRecord>

    /**
     *
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-cross-margin-account-details-user_data
     */
    fun account(): Response<Account>

    /**
     *
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-order-user_data
     */
    fun order(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?): Response<Order>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-margin-account-39-s-open-order-user_data
     */
    fun openOrders(symbol: String?, isIsolated: Boolean?): Response<List<Order>>

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
    ): Response<List<Order>>

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
    ): Response<List<Trade>>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-max-borrow-user_data
     */
    fun maxBorrowable(asset: String, isolatedSymbol: String?): Response<Amount>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-max-transfer-out-amount-user_data
     */
    fun maxTransferable(asset: String, isolatedSymbol: String?): Response<Amount>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#create-isolated-margin-account-margin
     */
    fun isolatedCreate(base: String, quote: String): Response<CreateIsolatedAccount>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#isolated-margin-account-transfer-margin
     */
    fun newIsolatedTransfer(
        asset: String,
        symbol: String,
        transFrom: TransactionTarget,
        transTo: TransactionTarget,
        amount: String
    ): Response<Transaction>

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
    ): Response<IsolatedTransferHistory>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount(): Response<IsolatedAccountInfo>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-account-info-user_data
     */
    fun isolatedAccount(symbols: List<String>): Response<IsolatedAccountInfo.IsolatedAccountInfoSymbols>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-isolated-margin-symbol-user_data
     */
    fun isolatedPair(symbol: String): Response<IsolatedPair>

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#get-all-isolated-margin-symbol-user_data
     */
    fun isolatedAllPairs(): Response<List<IsolatedPair>>

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun startMarginUserDataStream(): Response<ListenKey>

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun keepAliveMarginUserDataStream(listenKey: String): Response<Empty>

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-margin
     */
    fun deleteMarginUserDataStream(listenKey: String): Response<Empty>

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun startIsolatedMarginUserDataStream(symbol: String): Response<ListenKey>

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun keepAliveIsolatedMarginUserDataStream(listenKey: String): Response<Empty>

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-isolated-margin
     */
    fun deleteIsolatedMarginUserDataStream(listenKey: String): Response<Empty>
}