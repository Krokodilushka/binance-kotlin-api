package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceApiUnofficialRestClient

class RestUnofficialEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance()
            val client: BinanceApiUnofficialRestClient = factory.newUnofficialClient()

//            client.isolatedMarginPairListed().let { response ->
//                response.body()?.let { pairListed ->
//                    println("isolatedMarginPairListed: ${pairListed}")
//                    pairListed.data.forEach { pairListedData ->
//                        println(pairListedData)
//                    }
//                }
//            }

            client.isolatedMarginPairVipLevel().let { response ->
                response.body()?.let { pairVipLevel ->
//                    println("isolatedMarginPairVipLevel: ${pairVipLevel}")
                    pairVipLevel.data.filter { it.quote.assetName == "BTC" && it.base.assetName == "MATIC" }
                        .forEach { pairVipLevelData ->
                            println(pairVipLevelData.quote.levelDetails.find { it.level == 1 })
                        }
                }
            }

        }
    }
}