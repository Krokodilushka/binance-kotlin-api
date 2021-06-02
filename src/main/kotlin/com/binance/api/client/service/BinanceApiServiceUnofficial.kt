package com.binance.api.client.service

import com.binance.api.client.domain.rest.unofficial.PairListed
import com.binance.api.client.domain.rest.unofficial.PairVipLevel
import retrofit2.Call
import retrofit2.http.GET

interface BinanceApiServiceUnofficial {

    @GET("/bapi/margin/v1/public/isolated-margin/pair/listed")
    fun isolatedMarginPairListed(): Call<PairListed>

    @GET("/bapi/margin/v1/friendly/isolated-margin/pair/vip-level")
    fun isolatedMarginPairVipLevel(): Call<PairVipLevel>

}