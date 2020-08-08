package com.binance.api.client.impl

import com.binance.api.client.BinanceApiMarginRestClient
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.Amount
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.Transaction
import com.binance.api.client.domain.rest.margin.*
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceMargin

class BinanceApiMarginRestClientImpl(apiKey: String?, secret: String?) : BinanceApiMarginRestClient {

    private val binanceApiServiceMargin = BinanceApiServiceGenerator.createService(BinanceApiServiceMargin::class.java, apiKey, secret)

    override fun newCrossTransfer(asset: String, amount: String, type: Short): Transaction = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.newCrossTransfer(asset, amount, type, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun newLoan(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Transaction = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.newLoan(asset, isIsolated, symbol, amount, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun newRepay(asset: String, isIsolated: Boolean?, symbol: String?, amount: String): Transaction = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.newRepay(asset, isIsolated, symbol, amount, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun asset(symbol: String): CrossMarginAsset = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.asset(symbol))

    override fun pair(symbol: String): MarginPair = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.pair(symbol))

    override fun allAssets(): List<CrossMarginAsset> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.allAssets())

    override fun allPairs(): List<MarginPair> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.allPairs())

    override fun priceIndex(symbol: String): PriceIndex = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.priceIndex(symbol))

    override fun newOrder(symbol: String, isIsolated: Boolean?, side: OrderSide, type: OrderType, quantity: String, price: String?, stopPrice: String?, icebergQty: String?, newClientOrderId: String?, sideEffectType: OrderSideEffectType?, timeInForce: OrderTimeInForce?): NewOrder = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.newOrder(symbol, isIsolated, side, type, quantity, price, stopPrice, icebergQty, newClientOrderId, NewOrderResponseType.FULL, sideEffectType, timeInForce, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun cancelOrder(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?, newClientOrderId: String?): CancelOrder = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.cancelOrder(symbol, isIsolated, orderId, origClientOrderId, newClientOrderId, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun crossTransfer(asset: String?, type: TransferType?, startTime: String?, endTime: String?, current: String?, size: String?): TransferHistory = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.crossTransfer(asset, type, startTime, endTime, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun loan(asset: String, isolatedSymbol: String?, txId: Long?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): LoanRecord = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.loan(asset, isolatedSymbol, txId, startTime, endTime, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun repay(asset: String, isolatedSymbol: Boolean?, txId: Long?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): RepayRecord = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.repay(asset, isolatedSymbol, txId, startTime, endTime, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun interestHistory(asset: String?, isolatedSymbol: String?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): InterestHistory = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.interestHistory(asset, isolatedSymbol, startTime, endTime, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun forceLiquidationRec(startTime: Long?, endTime: Long?, isolatedSymbol: Boolean?, current: Long?, size: Long?): ForceLiquidationRecord = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.forceLiquidationRec(startTime, endTime, isolatedSymbol, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun account(): Account = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.account(BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun order(symbol: String, isIsolated: Boolean?, orderId: Long?, origClientOrderId: String?): Order = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.order(symbol, isIsolated, orderId, origClientOrderId, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun openOrders(symbol: String?, isIsolated: Boolean?): List<Order> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.openOrders(symbol, isIsolated, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun allOrders(symbol: String, isIsolated: Boolean?, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?): List<Order> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.allOrders(symbol, isIsolated, orderId, startTime, endTime, limit, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun myTrades(symbol: String, isIsolated: Boolean?, startTime: Long?, endTime: Long?, fromId: Long?, limit: Int?): List<Trade> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.myTrades(symbol, isIsolated, startTime, endTime, fromId, limit, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun maxBorrowable(asset: String, isolatedSymbol: String?): Amount = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.maxBorrowable(asset, isolatedSymbol, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun maxTransferable(asset: String, isolatedSymbol: String?): Amount = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.maxTransferable(asset, isolatedSymbol, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun isolatedCreate(base: String, quote: String): CreateIsolatedAccount = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.isolatedCreate(base, quote, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun newIsolatedTransfer(asset: String, symbol: String, transFrom: TransactionTarget, transTo: TransactionTarget, amount: String): Transaction = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.newIsolatedTransfer(asset, symbol, transFrom, transTo, amount, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun isolatedTransfer(asset: String?, symbol: String, transFrom: TransactionTarget?, transTo: TransactionTarget?, startTime: Long?, endTime: Long?, current: Long?, size: Long?): IsolatedTransferHistory = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.isolatedTransfer(asset, symbol, transFrom, transTo, startTime, endTime, current, size, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun isolatedAccount(): IsolatedAccountInfo = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.isolatedAccount(BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun isolatedPair(symbol: String): IsolatedPair = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.isolatedPair(symbol, BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun isolatedAllPairs(): List<IsolatedPair> = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.isolatedAllPairs(BinanceApiConstants.MARGIN_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun startMarginUserDataStream(): String = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.startMarginUserDataStream()).listenKey

    override fun keepAliveMarginUserDataStream(listenKey: String): Empty = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.keepAliveMarginUserDataStream(listenKey))

    override fun deleteMarginUserDataStream(listenKey: String): Empty = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.closeMarginUserDataStream(listenKey))

    override fun startIsolatedMarginUserDataStream(symbol: String): String = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.startIsolatedMarginUserDataStream(symbol)).listenKey

    override fun keepAliveIsolatedMarginUserDataStream(listenKey: String): Empty = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.keepAliveIsolatedMarginUserDataStream(listenKey))

    override fun deleteIsolatedMarginUserDataStream(listenKey: String): Empty = BinanceApiServiceGenerator.executeSync(binanceApiServiceMargin.closeIsolatedMarginUserDataStream(listenKey))

}