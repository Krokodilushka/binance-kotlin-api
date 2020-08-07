package com.binance.api.client.domain.general

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.RateLimitInterval
import com.binance.api.client.domain.RateLimitType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Rate limits.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class RateLimit {
    var rateLimitType: RateLimitType? = null
    var interval: RateLimitInterval? = null
    var limit: Int? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("rateLimitType", rateLimitType)
                .append("interval", interval)
                .append("limit", limit)
                .toString()
    }
}