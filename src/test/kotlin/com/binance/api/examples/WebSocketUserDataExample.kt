package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.websocket.UserDataEvent

/**
 * User data stream endpoints examples.
 *
 *
 * It illustrates how to create a stream to obtain updates on a user account,
 * as well as update on trades/orders on a user account.
 */
class WebSocketUserDataExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(
                    args.getOrElse(0) { "API_KEY" },
                    args.getOrElse(1) { "API_SECRET" }
            )

            // spot
            val restClient = factory.newSpotRestClient()
            val listenKey = restClient.startUserDataStream()
            // margin
//            val restClient = factory.newMarginRestClient()
//            val listenKey = restClient.startMarginUserDataStream()

            // Then, we open a new web socket client, and provide a callback that is called on every update
            val webSocketClient = factory.newWebSocketClient()

            // Listen for changes in the account
            webSocketClient.onUserDataUpdateEvent(listenKey, object : BinanceWebSocketClient.WebSocketCallback<UserDataEvent> {
                override fun onResponse(response: UserDataEvent) {
                    println("Event: ${response.event}:")
                    when (response.event) {
                        is UserDataEvent.Event.AccountUpdateEvent -> println(response.event)
                        is UserDataEvent.Event.OrderTradeUpdateEvent -> println(response.event)
                        is UserDataEvent.Event.BalanceUpdateEvent -> println(response.event)
                    }
                    println("")
                }

                override fun onFailure(cause: Throwable) {
                    throw cause
                }
            })
            println("Waiting for events...")

            Thread.sleep(5000L)
            // We can keep alive the user data stream
//            restClient.keepAliveUserDataStream(listenKey);

            // Or we can invalidate it, whenever it is no longer needed
//            restClient.closeUserDataStream(listenKey);
        }
    }
}