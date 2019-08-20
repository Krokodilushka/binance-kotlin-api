package com.binance.api.client;

import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.OrderRequest;

import java.util.List;

/**
 * Binance API façade, supporting asynchronous/non-blocking access Binance's Margin REST API.
 */
public interface BinanceApiAsyncMarginRestClient {

  // Account endpoints

  /**
   * Get current margin account information (async).
   */
  void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<MarginAccount> callback);

  /**
   * Get current margin account information using default parameters (async).
   */
  void getAccount(BinanceApiCallback<MarginAccount> callback);

  /**
   * Get all open orders on margin account for a symbol (asynchronous).
   *
   * @param orderRequest order request parameters
   * @param callback the callback that handles the response
   */
  void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<Order>> callback);

}