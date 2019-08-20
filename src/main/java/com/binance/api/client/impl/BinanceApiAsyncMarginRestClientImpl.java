package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.OrderRequest;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.createService;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiAsyncMarginRestClientImpl implements BinanceApiAsyncMarginRestClient {

  private final BinanceApiService binanceApiService;

  public BinanceApiAsyncMarginRestClientImpl(String apiKey, String secret) {
    binanceApiService = createService(BinanceApiService.class, apiKey, secret);
  }

  // Margin Account endpoints

  @Override
  public void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<MarginAccount> callback) {
    binanceApiService.getMarginAccount(recvWindow, timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));
  }

  @Override
  public void getAccount(BinanceApiCallback<MarginAccount> callback) {
    long timestamp = System.currentTimeMillis();
    binanceApiService.getMarginAccount(BinanceApiConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));
  }

  @Override
  public void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<Order>> callback) {
      binanceApiService.getOpenMarginOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(),
              orderRequest.getTimestamp()).enqueue(new BinanceApiCallbackAdapter<>(callback));
  }
}
