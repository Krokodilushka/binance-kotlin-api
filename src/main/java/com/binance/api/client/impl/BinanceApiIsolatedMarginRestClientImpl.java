package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiIsolatedMarginRestClient;
import com.binance.api.client.BinanceApiMarginRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.general.MarginPair;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.createService;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiIsolatedMarginRestClientImpl implements BinanceApiIsolatedMarginRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceApiIsolatedMarginRestClientImpl(String apiKey, String secret) {
        binanceApiService = createService(BinanceApiService.class, apiKey, secret);
    }

    // user stream endpoints

    @Override
    public String startUserDataStream(String symbol) {
        return executeSync(binanceApiService.startIsolatedMarginUserDataStream(symbol)).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey) {
        executeSync(binanceApiService.keepAliveIsolatedMarginUserDataStream(listenKey));
    }
}