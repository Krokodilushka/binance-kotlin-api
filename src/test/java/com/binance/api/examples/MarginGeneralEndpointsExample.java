package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiMarginRestClient;
import com.binance.api.client.domain.general.MarginPair;

import java.util.List;

/**
 * Examples on how to use the general endpoints.
 */
public class MarginGeneralEndpointsExample {

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiMarginRestClient client = factory.newMarginRestClient();

        // Exchange info
        List<MarginPair> marginPairs = client.getAllPairs();
        System.out.println(marginPairs);
    }
}
