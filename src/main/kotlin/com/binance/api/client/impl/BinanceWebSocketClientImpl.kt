package com.binance.api.client.impl

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.websocket.MarketEvent
import com.binance.api.client.domain.websocket.UserDataEvent
import com.fasterxml.jackson.core.type.TypeReference
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.Closeable
import java.util.*
import java.util.stream.Collectors

class BinanceWebSocketClientImpl(private val client: OkHttpClient?) : BinanceWebSocketClient {
    override fun onAggTradeEvent(symbols: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.AggTradeEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@aggTrade", s) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, MarketEvent.AggTradeEvent::class.java))
    }

    override fun onTradeEvent(symbol: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.TradeEvent>): Closeable {
        return createNewWebSocket("$symbol@trade", BinanceApiWebSocketListener(callback, MarketEvent.TradeEvent::class.java))
    }

    override fun onCandlestickEvent(symbols: String, interval: CandlestickInterval, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.CandlestickEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@kline_%s", s, interval.intervalId) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, MarketEvent.CandlestickEvent::class.java))
    }

    override fun onIndividualSymbolMiniTickerEvent(symbol: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolMiniTickerEvent>): Closeable {
        return createNewWebSocket("$symbol@miniTicker", BinanceApiWebSocketListener(callback, MarketEvent.IndividualSymbolMiniTickerEvent::class.java))
    }

    override fun onAllMarketMiniTickersEvent(callback: BinanceWebSocketClient.WebSocketCallback<List<MarketEvent.IndividualSymbolMiniTickerEvent>>): Closeable {
        val typeReference = object : TypeReference<List<MarketEvent.IndividualSymbolMiniTickerEvent>>() {}
        return createNewWebSocket("!miniTicker@arr", BinanceApiWebSocketListener(callback, typeReference))
    }

    override fun onIndividualSymbolTickerEvent(symbol: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolTickerEvent>): Closeable {
        return createNewWebSocket("$symbol@ticker", BinanceApiWebSocketListener(callback, MarketEvent.IndividualSymbolTickerEvent::class.java))
    }

    override fun onAllMarketTickersEvent(callback: BinanceWebSocketClient.WebSocketCallback<List<MarketEvent.AllMarketTickersEvent>>): Closeable {
        return createNewWebSocket("!ticker@arr", BinanceApiWebSocketListener(callback, object : TypeReference<List<MarketEvent.AllMarketTickersEvent>>() {}))
    }

    override fun onIndividualSymbolBookTickerEvent(symbol: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent>): Closeable {
        return createNewWebSocket("$symbol@bookTicker", BinanceApiWebSocketListener(callback, MarketEvent.IndividualSymbolBookTickerEvent::class.java))
    }

    override fun onAllBookTickersEvent(callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent>): Closeable {
        return createNewWebSocket("!bookTicker", BinanceApiWebSocketListener(callback, MarketEvent.IndividualSymbolBookTickerEvent::class.java))
    }

    override fun onPartialBookDepthEvent(symbol: String, levels: Int, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.PartialBookDepth>): Closeable {
        return createNewWebSocket("$symbol@depth$levels", BinanceApiWebSocketListener(callback, MarketEvent.PartialBookDepth::class.java))
    }

    override fun onDiffDepthEvent(symbols: String, callback: BinanceWebSocketClient.WebSocketCallback<MarketEvent.DepthEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@depth", s) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, MarketEvent.DepthEvent::class.java))
    }


    override fun onUserDataUpdateEvent(listenKey: String, callback: BinanceWebSocketClient.WebSocketCallback<UserDataEvent>): Closeable {
        return createNewWebSocket(listenKey, BinanceApiWebSocketListener(callback, UserDataEvent::class.java))
    }

    private fun createNewWebSocket(channel: String, listener: BinanceApiWebSocketListener<*>): Closeable {
        val streamingUrl = String.format("%s/%s", BinanceApiConstants.WS_API_BASE_URL, channel)
        val request = Request.Builder().url(streamingUrl).build()
        val webSocket = client!!.newWebSocket(request, listener)
        return Closeable {
            val code = 1000
            listener.onClosing(webSocket, code, "createNewWebSocket")
            webSocket.close(code, null)
            listener.onClosed(webSocket, code, "createNewWebSocket")
        }
    }

}