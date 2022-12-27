package com.binance.api.client.domain.rest.spot
import com.fasterxml.jackson.annotation.JsonProperty

data class Deposit(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("amount")
    val amount: String,
    @JsonProperty("coin")
    val coin: String,
    @JsonProperty("network")
    val network: String,
    @JsonProperty("status")
    val status: Int,
    @JsonProperty("address")
    val address: String,
    @JsonProperty("addressTag")
    val addressTag: String,
    @JsonProperty("txId")
    val txId: String,
    @JsonProperty("insertTime")
    val insertTime: Long,
    @JsonProperty("transferType")
    val transferType: Int,
    @JsonProperty("confirmTimes")
    val confirmTimes: String,
    @JsonProperty("unlockConfirm")
    val unlockConfirm: Int,
    @JsonProperty("walletType")
    val walletType: Int
)