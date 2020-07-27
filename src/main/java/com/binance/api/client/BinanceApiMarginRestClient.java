package com.binance.api.client;

import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.general.MarginPair;
import retrofit2.http.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BinanceApiMarginRestClient {
    /**
     * Get current margin account information using default parameters.
     */
    MarginAccount getAccount();

    /**
     * Get all open orders on margin account for a symbol.
     *
     * @param orderRequest order request parameters
     */
    List<Order> getOpenOrders(OrderRequest orderRequest);

    /**
     * Send in a new margin order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    NewOrderResponse newOrder(NewOrder order);

    /**
     * Cancel an active margin order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

    /**
     * Check margin order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    Order getOrderStatus(OrderStatusRequest orderStatusRequest);

    /**
     * Get margin trades for a specific symbol.
     *
     * @param symbol symbol to get trades from
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol);

    List<MarginPair> getAllPairs();

    MaxBorrowable getMaxBorrowable(String asset);

    MarginLoan newMarginLoan(String asset, String amount);

    MarginLoan newMarginRepay(String asset, String amount);

    // User stream endpoints

    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream();


    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey);
}
