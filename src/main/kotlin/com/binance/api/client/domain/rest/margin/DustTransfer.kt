package com.binance.api.client.domain.rest.margin

data class DustTransfer(
    val totalServiceCharge: String,
    val totalTransfered: String,
    val transferResult: List<TransferResult>
) {
    data class TransferResult(
        val amount: String,
        val fromAsset: String,
        val operateTime: Long,
        val serviceChargeAmount: String,
        val tranId: Long,
        val transferedAmount: String
    )
}