package com.binance.api.client.domain.account.spot


import com.binance.api.client.domain.Permission
import com.fasterxml.jackson.annotation.JsonProperty

data class Account(
        @JsonProperty("makerCommission")
        val makerCommission: Int,
        @JsonProperty("takerCommission")
        val takerCommission: Int,
        @JsonProperty("buyerCommission")
        val buyerCommission: Int,
        @JsonProperty("sellerCommission")
        val sellerCommission: Int,
        @JsonProperty("canTrade")
        val canTrade: Boolean,
        @JsonProperty("canWithdraw")
        val canWithdraw: Boolean,
        @JsonProperty("canDeposit")
        val canDeposit: Boolean,
        @JsonProperty("updateTime")
        val updateTime: Long,
        @JsonProperty("accountType")
        val accountType: String,
        @JsonProperty("balances")
        val balances: List<Balance>,
        @JsonProperty("permissions")
        val permissions: List<Permission>
) {
    data class Balance(
            @JsonProperty("asset")
            val asset: String,
            @JsonProperty("free")
            val free: String,
            @JsonProperty("locked")
            val locked: String
    )
}