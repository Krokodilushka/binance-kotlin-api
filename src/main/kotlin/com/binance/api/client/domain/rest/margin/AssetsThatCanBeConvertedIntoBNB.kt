package com.binance.api.client.domain.rest.margin

data class AssetsThatCanBeConvertedIntoBNB(
    val details: List<Detail>,
    val totalTransferBtc: String,
    val totalTransferBNB: String,
    val dribbletPercentage: String
) {
    data class Detail(
        val asset: String,
        val assetFullName: String,
        val amountFree: String,
        val toBTC: String,
        val toBNB: String,
        val toBNBOffExchange: String,
        val exchange: String
    )
}