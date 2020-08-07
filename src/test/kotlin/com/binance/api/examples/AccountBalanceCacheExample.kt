package com.binance.api.examples

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory
import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.account.AssetBalance
import com.binance.api.client.domain.event.UserDataUpdateEvent
import java.util.*

/**
 * Illustrates how to use the user data event stream to create a local cache for the balance of an account.
 */
class AccountBalanceCacheExample(apiKey: String?, secret: String?) {
    private val clientFactory: BinanceApiClientFactory

    /**
     * Key is the symbol, and the value is the balance of that symbol on the account.
     */
    private var accountBalanceCache: MutableMap<String?, AssetBalance>? = null

    /**
     * Initializes the asset balance cache by using the REST API and starts a new user data streaming session.
     *
     * @return a listenKey that can be used with the user data streaming API.
     */
    private fun initializeAssetBalanceCacheAndStreamSession(): String {
        val client = clientFactory.newRestClient()
        val account = client.getAccount()
        accountBalanceCache = TreeMap()
        for (assetBalance in Objects.requireNonNull(Objects.requireNonNull(account).balances)!!) {
            accountBalanceCache!![assetBalance.asset] = assetBalance
        }
        return client.startUserDataStream()
    }

    /**
     * Begins streaming of agg trades events.
     */
    private fun startAccountBalanceEventStreaming(listenKey: String) {
        val client = clientFactory.newWebSocketClient()
        client.onUserDataUpdateEvent(listenKey, object : BinanceApiCallback<UserDataUpdateEvent> {
            override fun onResponse(response: UserDataUpdateEvent) {
                if (response.eventType === UserDataUpdateEvent.UserDataUpdateEventType.ACCOUNT_UPDATE) {
                    // Override cached asset balances
                    for (assetBalance in Objects.requireNonNull(Objects.requireNonNull(response.accountUpdateEvent)!!.balances)!!) {
                        accountBalanceCache!![assetBalance.asset] = assetBalance
                    }
                    println(accountBalanceCache)
                }
            }
        })
    }

    /**
     * @return an account balance cache, containing the balance for every asset in this account.
     */
    fun getAccountBalanceCache(): Map<String?, AssetBalance>? {
        return accountBalanceCache
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AccountBalanceCacheExample("YOUR_API_KEY", "YOUR_SECRET")
        }
    }

    init {
        clientFactory = newInstance(apiKey, secret)
        // Listen key used to interact with the user data streaming API.
        val listenKey = initializeAssetBalanceCacheAndStreamSession()
        startAccountBalanceEventStreaming(listenKey)
    }
}