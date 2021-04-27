package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceApiWebSocketListener
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketMessage
import com.binance.api.client.domain.websocket.WebSocketStream

class WebSocketUserDataExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val binanceApiClientFactory = newInstance(
                args.getOrElse(0) { "API_KEY" },
                args.getOrElse(1) { "API_SECRET" }
            )

//            val marginClient = binanceApiClientFactory.newMarginRestClient()
            val spotListenKey = binanceApiClientFactory.newSpotRestClient().startUserDataStream()
//            val marginListenKey = marginClient.startMarginUserDataStream()
//            val isolatedMarginBtcUsdtListenKey = marginClient.startIsolatedMarginUserDataStream("neobtc")
//            Thread.sleep(500L)
//            val isolatedMarginBtcEthListenKey = marginClient.startIsolatedMarginUserDataStream("ethbtc")
            val channels = listOf(
                WebSocketStream.AllMarketTickers(),
//                    WebSocketStream.Trade("btcusdt")
                WebSocketStream.UserData(spotListenKey.body()!!.listenKey)
//                    WebSocketStream.UserData(marginListenKey)
//                WebSocketStream.UserData(isolatedMarginBtcUsdtListenKey.body()!!.listenKey)
//                    WebSocketStream.UserData(isolatedMarginBtcEthListenKey)
            )

            var webSocketClient: BinanceWebSocketClient? = null
            val callback = object : BinanceWebSocketClient.WebSocketCallback {
                override fun onEvent(eventWrapper: WebSocketEvent.Wrapper<WebSocketEvent>) {
                    if (eventWrapper.stream != "!ticker@arr") {
                        println("\nonEvent: $eventWrapper")
                    } else {
                        print(".")
                    }
                }

                override fun onMessage(message: WebSocketMessage.Wrapper<WebSocketMessage.Wrapper.Response>) {
                    println("onMessage: $message")
                }

                override fun onFailure(cause: Throwable) {
                    println("onFailure $cause")
                    if (cause is java.io.EOFException) {
                        println("reconnect")
                        webSocketClient?.connect(channels)
                    }
                }

                override fun onClosing(code: Int, reason: String) {
                    println("onClosing code: $code, reason: $reason")
                }
            }
            val webSocketListener = BinanceApiWebSocketListener(callback)
            webSocketClient = binanceApiClientFactory.newWebSocketClient(webSocketListener)

            println("channels: " + channels)
            webSocketClient.connect(channels)
            println("Wait events...")

//            Thread.sleep(1000L)
//            val ct1 = WebSocketStream.Candlestick("btcusdt", CandlestickInterval.ONE_MINUTE).toString()
//            val ct2 = WebSocketStream.Candlestick("ethusdt", CandlestickInterval.ONE_MINUTE).toString()
//            val ct3 = WebSocketStream.Candlestick("xrpusdt", CandlestickInterval.ONE_MINUTE).toString()
//            WebSocketMessage.Request(WebSocketMessage.Method.SUBSCRIBE, listOf(ct1), 1).let {
//                webSocketClient.message(it)
//            }
//            Thread.sleep(5000L)
//            WebSocketMessage.Request(WebSocketMessage.Method.SUBSCRIBE, listOf(ct2), 2).let {
//                webSocketClient.message(it)
//            }
//            Thread.sleep(5000L)
//            WebSocketMessage.Request(WebSocketMessage.Method.SUBSCRIBE, listOf(ct3), 3).let {
//                webSocketClient.message(it)
//            }
//            Thread.sleep(5000L)
//            WebSocketMessage.Request(WebSocketMessage.Method.UNSUBSCRIBE, listOf(ct1, ct2), 4).let {
//                webSocketClient.message(it)
//            }
        }
    }
}