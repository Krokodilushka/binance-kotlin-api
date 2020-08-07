package com.binance.api.examples

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.event.UserDataUpdateEvent
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType

/**
 * User data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on a user account,
 * as well as update on trades/orders on a user account.
 */
class MarginUserDataStreamExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance("YOUR_API_KEY", "YOUR_SECRET")
            val client = factory.newMarginRestClient()

            // First, we obtain a listenKey which is required to interact with the user data stream
            val listenKey = client.startUserDataStream()

            // Then, we open a new web socket client, and provide a callback that is called on every update
            val webSocketClient = factory.newWebSocketClient()

            // Listen for changes in the account
            webSocketClient.onUserDataUpdateEvent(listenKey, object : BinanceApiCallback<UserDataUpdateEvent> {
                override fun onResponse(response: UserDataUpdateEvent) {
                    if (response.eventType === UserDataUpdateEventType.ACCOUNT_UPDATE) {
                        val accountUpdateEvent = response.accountUpdateEvent
                        // Print new balances of every available asset
                        println(accountUpdateEvent!!.balances)
                    } else {
                        val orderTradeUpdateEvent = response.orderTradeUpdateEvent
                        // Print details about an order/trade
                        println(orderTradeUpdateEvent)

                        // Print original quantity
                        println(orderTradeUpdateEvent!!.originalQuantity)

                        // Or price
                        println(orderTradeUpdateEvent.price)
                    }
                }
            })
            println("Waiting for events...")

            // We can keep alive the user data stream
            // client.keepAliveUserDataStream(listenKey);

            // Or we can invalidate it, whenever it is no longer needed
            // client.closeUserDataStream(listenKey);
        }
    }
}