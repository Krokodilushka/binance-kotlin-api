package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.WebSocketCallback
import com.binance.api.client.domain.websocket.event.UserDataUpdateEvent
import com.binance.api.client.domain.websocket.event.UserDataUpdateEvent.UserDataUpdateEventType

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
            webSocketClient.onUserDataUpdateEvent(listenKey, object : WebSocketCallback<UserDataUpdateEvent> {
                override fun onResponse(response: UserDataUpdateEvent) {
                    println("${response.eventType}:")
                    println("$response")
                    when (response.eventType) {
                        UserDataUpdateEventType.ACCOUNT_UPDATE, UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE -> println(response.accountUpdateEvent)
                        UserDataUpdateEventType.BALANCE_UPDATE -> println(response.balanceUpdateEvent)
                        UserDataUpdateEventType.ORDER_TRADE_UPDATE -> println(response.orderTradeUpdateEvent)
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