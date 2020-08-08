package com.binance.api.client

import com.binance.api.client.domain.*
import com.binance.api.client.domain.account.Amount
import com.binance.api.client.domain.account.Empty
import com.binance.api.client.domain.account.Transaction
import com.binance.api.client.domain.account.margin.*
import com.binance.api.client.domain.account.request.IsolatedMarginPair

interface BinanceApiMarginRestClient {

    fun newCrossTransfer(
            asset: String,
            amount: String,
            type: Short
    ): Transaction

    fun newLoan(
            asset: String,
            isIsolated: Boolean?,
            symbol: String?,
            amount: String
    ): Transaction

    fun newRepay(
            asset: String,
            isIsolated: Boolean?,
            symbol: String?,
            amount: String
    ): Transaction

    fun asset(symbol: String): CrossMarginAsset

    fun pair(symbol: String): MarginPair

    fun allAssets(): List<CrossMarginAsset>

    fun allPairs(): List<MarginPair>

    fun priceIndex(symbol: String): PriceIndex

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
    ): NewOrder

    fun cancelOrder(
            symbol: String,
            isIsolated: Boolean?,
            orderId: Long?,
            origClientOrderId: String?,
            newClientOrderId: String?
    ): CancelOrder

    fun crossTransfer(
            asset: String?,
            type: TransferType?,
            startTime: String?,
            endTime: String?,
            current: String?,
            size: String?
    ): TransferHistory

    fun loan(
            asset: String,
            isolatedSymbol: String?,
            txId: Long?,
            startTime: Long?,
            endTime: Long?,
            current: Long?,
            size: Long?
    ): LoanRecord

    fun repay(
            asset: String,
            isolatedSymbol: Boolean?,
            txId: Long?,
            startTime: Long?,
            endTime: Long?,
            current: Long?,
            size: Long?
    ): RepayRecord

    fun interestHistory(
            asset: String?,
            isolatedSymbol: String?,
            startTime: Long?,
            endTime: Long?,
            current: Long?,
            size: Long?
    ): InterestHistory

    fun forceLiquidationRec(
            startTime: Long?,
            endTime: Long?,
            isolatedSymbol: Boolean?,
            current: Long?,
            size: Long?
    ): ForceLiquidationRecord

    fun account(): Account

    fun order(
            symbol: String,
            isIsolated: Boolean?,
            orderId: Long?,
            origClientOrderId: String?
    ): Order

    fun openOrders(
            symbol: String?,
            isIsolated: Boolean?
    ): List<Order>

    fun allOrders(
            symbol: String,
            isIsolated: Boolean?,
            orderId: Long?,
            startTime: Long?,
            endTime: Long?,
            limit: Int?
    ): List<Order>

    fun myTrades(
            symbol: String,
            isIsolated: Boolean?,
            startTime: Long?,
            endTime: Long?,
            fromId: Long?,
            limit: Int?
    ): List<com.binance.api.client.domain.account.margin.Trade>

    fun maxBorrowable(
            asset: String,
            isolatedSymbol: String?
    ): Amount

    fun maxTransferable(
            asset: String,
            isolatedSymbol: String?
    ): Amount

    fun isolatedCreate(
            base: String,
            quote: String
    ): CreateIsolatedAccount

    fun newIsolatedTransfer(
            asset: String,
            symbol: String,
            transFrom: TransactionTarget,
            transTo: TransactionTarget,
            amount: String
    ): Transaction

    fun isolatedTransfer(
            asset: String?,
            symbol: String,
            transFrom: TransactionTarget?,
            transTo: TransactionTarget?,
            startTime: Long?,
            endTime: Long?,
            current: Long?,
            size: Long?
    ): IsolatedTransferHistory

    fun isolatedAccount(): IsolatedAccountInfo

    fun isolatedPair(symbol: String): IsolatedMarginPair

    fun isolatedAllPairs(): List<IsolatedMarginPair>

    fun startMarginUserDataStream(): String

    fun keepAliveMarginUserDataStream(listenKey: String): Empty

    fun deleteMarginUserDataStream(listenKey: String): Empty

    fun startIsolatedMarginUserDataStream(symbol: String): String

    fun keepAliveIsolatedMarginUserDataStream(listenKey: String): Empty

    fun deleteIsolatedMarginUserDataStream(listenKey: String): Empty
}