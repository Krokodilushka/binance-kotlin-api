package com.binance.api.client.domain.rest.spot
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class WithdrawRecord(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("amount")
    val amount: BigDecimal,
    @JsonProperty("transactionFee")
    val transactionFee: BigDecimal,
    @JsonProperty("coin")
    val coin: String,
    @JsonProperty("status")
    val status: Int,
    @JsonProperty("address")
    val address: String,
    @JsonProperty("txId")
    val txId: String?,
    @JsonProperty("applyTime")
    val applyTime: String,
    @JsonProperty("network")
    val network: String,
    @JsonProperty("transferType")
    val transferType: Int,
    @JsonProperty("info")
    val info: String?,
    @JsonProperty("confirmNo")
    val confirmNo: Int,
    @JsonProperty("walletType")
    val walletType: Int,
    @JsonProperty("txKey")
    val txKey: String?
)