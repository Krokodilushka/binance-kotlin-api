package com.binance.api.client

@FunctionalInterface
interface WebSocketCallback<T> {
    fun onResponse(response: T)
    fun onFailure(cause: Throwable) {}
}