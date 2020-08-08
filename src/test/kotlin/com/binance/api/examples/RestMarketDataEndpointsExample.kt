package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance

class RestMarketDataEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(
                    args.getOrElse(0) { "API_KEY" },
                    args.getOrElse(1) { "API_SECRET" }
            )
            val client = factory.newMarketDataRestClient()

//            client.ping().let {
//                println("ping: $it")
//            }

//            client.time().let {
//                println("time: $it")
//            }

//            client.exchangeInfo().let {
//                println("exchangeInfo: ${it}")
//            }

//            client.depth("BTCUSDT", 5).let {
//                println("depth: $it")
//            }

//            client.trades("BTCUSDT", 5).let {
//                println("trades: $it")
//            }

            client.historicalTrades("BTCUSDT", 5, null).let {
                println("historicalTrades: $it")
            }

//            client.aggTrades("BTCUSDT", null, null, null, null).let {
//                println("aggTrades: $it")
//            }

//            client.klines("BTCUSDT", CandlestickInterval.HOURLY, null, null, 5).let {
//                println("klines: $it")
//            }

//            client.avgPrice("BTCUSDT").let {
//                println("avgPrice: $it")
//            }

//            client.ticker24hr("BTCUSDT").let {
//                println("ticker24hr: $it")
//            }
//
//            client.tickers24hr().let {
//                println("tickers24hr: $it")
//            }

//            client.tickerPrice("BTCUSDT").let {
//                println("tickerPrice: $it")
//            }
//
//            client.tickersPrice().let {
//                println("tickersPrice: $it")
//            }

//            client.tickerBookTicker("BTCUSDT").let {
//                println("tickerPrice: $it")
//            }
//
//            client.tickersBookTicker().let {
//                println("tickersBookTicker: $it")
//            }

        }
    }
}