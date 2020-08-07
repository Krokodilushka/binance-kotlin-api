package com.binance.api.client.domain.account

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * @see NewOrderResponse
 */
class NewOrderResponseTest {
    private var newOrderResponse: NewOrderResponse? = null
    private var trade: Trade? = null

    @Before
    fun setUp() {
        newOrderResponse = NewOrderResponse()
        trade = Trade()
        trade!!.id = 123L
    }

    @Test
    fun shouldHandleToStringWithNullFills() {
        Assert.assertThat(newOrderResponse.toString(), CoreMatchers.containsString(",fills="))
    }

    @Test
    fun shouldHandleToStringWithNoFills() {
        newOrderResponse!!.fills = emptyList()
        Assert.assertThat(newOrderResponse.toString(), CoreMatchers.containsString(",fills="))
    }

    @Test
    fun shouldHandleToStringWithFills() {
        newOrderResponse!!.fills = trades(trade!!)
        Assert.assertThat(newOrderResponse.toString(), CoreMatchers.containsString(",fills=Trade[id=123,"))
    }

    companion object {
        private fun trades(vararg trades: Trade): List<Trade> {
            return Arrays.asList(*trades)
        }
    }
}