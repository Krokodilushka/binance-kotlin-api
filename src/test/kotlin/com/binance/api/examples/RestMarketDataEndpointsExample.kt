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

            client.exchangeInfo().let {
//                println("exchangeInfo: ${it}")
                it.exchangeFilters.forEach {
                    print("$it")
                }
//                it.symbols.filter { it.filters.any { it is SymbolFilter.PriceFilter } }.forEach {
//                    println("PriceFilter for ${it.symbol}: ${it.filters.find { it is SymbolFilter.PriceFilter }}")
//                }
            }

//            client.depth("BTCUSDT", 5).let {
//                println("depth: $it")
//            }

//            client.trades("BTCUSDT", 5).let {
//                println("trades: $it")
//            }

//            client.historicalTrades("BTCUSDT", 5, null).let {
//                println("historicalTrades: $it")
//            }

//            client.aggTrades("BTCUSDT", null, null, null, null).let {
//                println("aggTrades: $it")
//            }

//            client.klines("BTCUSDT", CandlestickInterval.HOURLY, null, null, 5).let {
//                println("klines: $it")
//            }

//            client.avgPrice("BTCUSDT").let {
//                println("avgPrice: $it")
//            }

//            try {
//                client.ticker24hr("UNKNOWN").let {
//                    println("ticker24hr: $it")
//                }
//            } catch (e: BinanceApiException) {
//                println("BinanceApiException: ${e.apiError?.code} ${e.apiError?.msg}")
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