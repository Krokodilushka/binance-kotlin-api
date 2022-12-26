package com.binance.api.client.domain.rest.spot
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class WalletAllCoinsInformation(
    @JsonProperty("coin")
    val coin: String,
    @JsonProperty("depositAllEnable")
    val depositAllEnable: Boolean,
    @JsonProperty("free")
    val free: String,
    @JsonProperty("freeze")
    val freeze: String,
    @JsonProperty("ipoable")
    val ipoable: String,
    @JsonProperty("ipoing")
    val ipoing: String,
    @JsonProperty("isLegalMoney")
    val isLegalMoney: Boolean,
    @JsonProperty("locked")
    val locked: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("networkList")
    val networkList: List<Network>,
    @JsonProperty("storage")
    val storage: String,
    @JsonProperty("trading")
    val trading: Boolean,
    @JsonProperty("withdrawAllEnable")
    val withdrawAllEnable: Boolean,
    @JsonProperty("withdrawing")
    val withdrawing: String
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Network(
        @JsonProperty("addressRegex")
        val addressRegex: String,
        @JsonProperty("coin")
        val coin: String,
        @JsonProperty("depositDesc")
        val depositDesc: String,
        @JsonProperty("depositEnable")
        val depositEnable: Boolean,
        @JsonProperty("isDefault")
        val isDefault: Boolean,
        @JsonProperty("memoRegex")
        val memoRegex: String,
        @JsonProperty("minConfirm")
        val minConfirm: Int,
        @JsonProperty("name")
        val name: String,
        @JsonProperty("network")
        val network: String,
        @JsonProperty("resetAddressStatus")
        val resetAddressStatus: Boolean,
        @JsonProperty("specialTips")
        val specialTips: String?,
        @JsonProperty("withdrawEnable")
        val withdrawEnable: Boolean,
        @JsonProperty("withdrawFee")
        val withdrawFee: String,
        @JsonProperty("withdrawMin")
        val withdrawMin: String,
        @JsonProperty("withdrawMax")
        val withdrawMax: String,
    )
}