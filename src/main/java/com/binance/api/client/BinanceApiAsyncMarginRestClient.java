package com.binance.api.client;

import com.binance.api.client.domain.account.MarginAccount;

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
}