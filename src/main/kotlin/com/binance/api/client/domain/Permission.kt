package com.binance.api.client.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = false)
enum class Permission {
    SPOT, MARGIN
}