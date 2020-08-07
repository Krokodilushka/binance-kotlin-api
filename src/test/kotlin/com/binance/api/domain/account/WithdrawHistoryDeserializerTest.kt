package com.binance.api.domain.account

import com.binance.api.client.domain.account.WithdrawHistory
import com.fasterxml.jackson.databind.ObjectMapper
import junit.framework.TestCase
import org.junit.Test
import java.io.IOException

/**
 * Test deserialization of a withdraw/deposit history.
 */
class WithdrawHistoryDeserializerTest {
    @Test
    fun testWithdrawHistoryDeserialziation() {
        val withdrawHistoryJson = """
            {"withdrawList":
            [{"amount":0.1,"address":"0x456","successTime":"2017-10-13 21:20:09",
            "txId":"0x123","id":"1","asset":"ETH","applyTime":"2017-10-13 20:59:38","userId":"1","status":6}],
            "success":true}
            """.trimIndent()
        val mapper = ObjectMapper()
        try {
            val withdrawHistory = mapper.readValue(withdrawHistoryJson, WithdrawHistory::class.java)
            TestCase.assertTrue(withdrawHistory.isSuccess)
            val withdrawList = withdrawHistory.withdrawList
            TestCase.assertEquals(withdrawHistory.withdrawList!!.size, 1)
            val withdraw = withdrawList!![0]
            TestCase.assertEquals(withdraw.amount, "0.1")
            TestCase.assertEquals(withdraw.address, "0x456")
            TestCase.assertEquals(withdraw.asset, "ETH")
            TestCase.assertEquals(withdraw.applyTime, "2017-10-13 20:59:38")
            TestCase.assertEquals(withdraw.successTime, "2017-10-13 21:20:09")
            TestCase.assertEquals(withdraw.txId, "0x123")
            TestCase.assertEquals(withdraw.id, "1")
        } catch (e: IOException) {
            TestCase.fail(e.message)
        }
    }
}