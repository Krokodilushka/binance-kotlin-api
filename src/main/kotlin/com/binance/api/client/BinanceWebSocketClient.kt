package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.websocket.MarketEvent
import com.binance.api.client.domain.websocket.UserDataEvent
import java.io.Closeable

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
interface BinanceWebSocketClient {

    fun onAggTradeEvent(symbols: String, callback: WebSocketCallback<MarketEvent.AggTradeEvent>): Closeable

    fun onTradeEvent(symbol: String, callback: WebSocketCallback<MarketEvent.TradeEvent>): Closeable

    fun onCandlestickEvent(symbols: String, interval: CandlestickInterval, callback: WebSocketCallback<MarketEvent.CandlestickEvent>): Closeable

    fun onIndividualSymbolMiniTickerEvent(symbol: String, callback: WebSocketCallback<MarketEvent.IndividualSymbolMiniTickerEvent>): Closeable

    fun onAllMarketMiniTickersEvent(callback: WebSocketCallback<List<MarketEvent.IndividualSymbolMiniTickerEvent>>): Closeable

    fun onIndividualSymbolTickerEvent(symbol: String, callback: WebSocketCallback<MarketEvent.IndividualSymbolTickerEvent>): Closeable

    fun onAllMarketTickersEvent(callback: WebSocketCallback<List<MarketEvent.AllMarketTickersEvent>>): Closeable

    fun onIndividualSymbolBookTickerEvent(symbol: String, callback: WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent>): Closeable

    fun onAllBookTickersEvent(callback: WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent>): Closeable

    fun onPartialBookDepthEvent(symbol: String, levels: Int, callback: WebSocketCallback<MarketEvent.PartialBookDepth>): Closeable

    fun onDiffDepthEvent(symbols: String, callback: WebSocketCallback<MarketEvent.DepthEvent>): Closeable

    fun onUserDataUpdateEvent(listenKey: String, callback: WebSocketCallback<UserDataEvent>): Closeable

}
