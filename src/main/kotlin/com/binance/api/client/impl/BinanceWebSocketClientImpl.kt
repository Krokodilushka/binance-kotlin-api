package com.binance.api.client.impl

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.websocket.MarketEvent
import com.binance.api.client.domain.websocket.UserDataEvent
import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.*
import java.io.Closeable
import java.io.IOException
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

    class BinanceApiWebSocketListener<T> : WebSocketListener {
        private val mapper = ObjectMapper().registerKotlinModule()
        private val callback: BinanceWebSocketClient.WebSocketCallback<T>
        private val objectReader: ObjectReader
        private var closing = false

        constructor(callback: BinanceWebSocketClient.WebSocketCallback<T>, eventClass: Class<T>) {
            this.callback = callback
            objectReader = mapper.readerFor(eventClass)
        }

        constructor(callback: BinanceWebSocketClient.WebSocketCallback<T>, eventTypeReference: TypeReference<T>) {
            this.callback = callback
            objectReader = mapper.readerFor(eventTypeReference)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            try {
                val event: T = objectReader.readValue(text)
                callback.onResponse(event)
            } catch (e: IOException) {
                throw BinanceApiException(e)
            }
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            closing = true
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            if (!closing) {
                callback.onFailure(t)
            }
        }

    }
}