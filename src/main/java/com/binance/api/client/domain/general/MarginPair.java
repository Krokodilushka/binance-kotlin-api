package com.binance.api.client.domain.general;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginPair {

    private Long id;
    private String symbol;
    private String base;
    private String quote;
    private Boolean isBuyAllowed;
    private Boolean isMarginTrade;
    private Boolean isSellAllowed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Boolean getIsBuyAllowed() {
        return isBuyAllowed;
    }

    public void setIsBuyAllowed(Boolean isBuyAllowed) {
        this.isBuyAllowed = isBuyAllowed;
    }

    public Boolean getIsMarginTrade() {
        return isMarginTrade;
    }

    public void setIsMarginTrade(Boolean isMarginTrade) {
        this.isMarginTrade = isMarginTrade;
    }

    public Boolean getIsSellAllowed() {
        return isSellAllowed;
    }

    public void setIsSellAllowed(Boolean isSellAllowed) {
        this.isSellAllowed = isSellAllowed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("symbol", symbol)
                .append("base", base)
                .append("quote", quote)
                .append("buyAllowed", isBuyAllowed)
                .append("marginTrade", isMarginTrade)
                .append("sellAllowed", isSellAllowed)
                .toString();
    }
}
