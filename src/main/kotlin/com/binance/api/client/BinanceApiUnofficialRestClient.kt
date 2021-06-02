package com.binance.api.client

import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceUnofficial

class BinanceApiUnofficialRestClient(baseUrl: String) {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceUnofficial::class.java, null, null, baseUrl)

    fun isolatedMarginPairListed() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.isolatedMarginPairListed())

    fun isolatedMarginPairVipLevel() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.isolatedMarginPairVipLevel())

}