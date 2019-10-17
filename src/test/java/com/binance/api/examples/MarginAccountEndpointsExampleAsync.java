package com.binance.api.examples;

import com.binance.api.client.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.BinanceApiClientFactory;

/**
 * Examples on how to get margin account information asynchronously.
 */
public class MarginAccountEndpointsExampleAsync {

  public static void main(String[] args) {
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
    BinanceApiAsyncMarginRestClient client = factory.newAsyncMarginRestClient();

    // Get account balances
    client.getAccount(marginAccount -> {
      System.out.println(marginAccount.getUserAssets());
      System.out.println(marginAccount.getAssetBalance("ETH"));
      System.out.println(marginAccount.getMarginLevel());
    });

    // Get list of trades
    client.getMyTrades("NEOETH", myTrades -> {
      System.out.println(myTrades);
    });
  }
}
