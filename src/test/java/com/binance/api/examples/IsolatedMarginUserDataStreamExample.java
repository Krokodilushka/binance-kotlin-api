package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiIsolatedMarginRestClient;
import com.binance.api.client.BinanceApiMarginRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.AccountUpdateEvent;
import com.binance.api.client.domain.event.OrderTradeUpdateEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType;

/**
 * User data stream endpoints examples.
 * <p>
 * It illustrates how to create a stream to obtain updates on a user account,
 * as well as update on trades/orders on a user account.
 */
public class IsolatedMarginUserDataStreamExample {

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("API_KEY", "API_SECRET");
        BinanceApiIsolatedMarginRestClient client = factory.newIsolatedMarginRestClient();

        // First, we obtain a listenKey which is required to interact with the user data stream
        String listenKey = client.startUserDataStream("BNBBTC");

        // Then, we open a new web socket client, and provide a callback that is called on every update
        BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        // Listen for changes in the account
        webSocketClient.onUserDataUpdateEvent(listenKey, response -> {

            System.out.println(response);
            if (response.getEventType() == UserDataUpdateEventType.ACCOUNT_UPDATE) {
                AccountUpdateEvent accountUpdateEvent = response.getAccountUpdateEvent();
                // Print new balances of every available asset
                System.out.println(accountUpdateEvent.getBalances());
            } else if (response.getEventType() == UserDataUpdateEventType.BALANCE_UPDATE) {
                System.out.println(response.getBalanceUpdateEvent());
            } else {
                OrderTradeUpdateEvent orderTradeUpdateEvent = response.getOrderTradeUpdateEvent();
                // Print details about an order/trade
                System.out.println(orderTradeUpdateEvent);

                // Print original quantity
                System.out.println(orderTradeUpdateEvent.getOriginalQuantity());

                // Or price
                System.out.println(orderTradeUpdateEvent.getPrice());
            }
        });
        System.out.println("Waiting for events...");

        // We can keep alive the user data stream
        // client.keepAliveUserDataStream(listenKey);

        // Or we can invalidate it, whenever it is no longer needed
        // client.closeUserDataStream(listenKey);
    }
}
