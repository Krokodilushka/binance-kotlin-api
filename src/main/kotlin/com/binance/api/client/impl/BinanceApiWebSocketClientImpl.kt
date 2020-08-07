package com.binance.api.client.impl

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiWebSocketClient
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.event.*
import com.binance.api.client.domain.market.CandlestickInterval
import com.fasterxml.jackson.core.type.TypeReference
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.Closeable
import java.util.*
import java.util.stream.Collectors

/**
 * Binance API WebSocket client implementation using OkHttp.
 */
class BinanceApiWebSocketClientImpl(private val client: OkHttpClient?) : BinanceApiWebSocketClient {
    override fun onDepthEvent(symbols: String, callback: BinanceApiCallback<DepthEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@depth", s) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, DepthEvent::class.java))
    }

    override fun onCandlestickEvent(symbols: String, interval: CandlestickInterval, callback: BinanceApiCallback<CandlestickEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@kline_%s", s, interval.intervalId) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, CandlestickEvent::class.java))
    }

    override fun onAggTradeEvent(symbols: String, callback: BinanceApiCallback<AggTradeEvent>): Closeable {
        val channel = Arrays.stream(symbols.split(",").toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { s: String? -> String.format("%s@aggTrade", s) }
                .collect(Collectors.joining("/"))
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, AggTradeEvent::class.java))
    }

    override fun onUserDataUpdateEvent(listenKey: String, callback: BinanceApiCallback<UserDataUpdateEvent>): Closeable {
        return createNewWebSocket(listenKey, BinanceApiWebSocketListener(callback, UserDataUpdateEvent::class.java))
    }

    override fun onAllMarketTickersEvent(callback: BinanceApiCallback<List<AllMarketTickersEvent>>): Closeable {
        val channel = "!ticker@arr"
        return createNewWebSocket(channel, BinanceApiWebSocketListener(callback, object : TypeReference<List<AllMarketTickersEvent>>() {}))
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