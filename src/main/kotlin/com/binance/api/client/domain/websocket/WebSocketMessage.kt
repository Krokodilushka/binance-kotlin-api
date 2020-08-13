package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.websocket.deserializer.WebSocketMessageEventDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

sealed class WebSocketMessage {


    @JsonDeserialize(using = WebSocketMessageEventDeserializer::class)
    data class Wrapper<T : Wrapper.Response>(
            val response: T
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        abstract class Response {
            data class Result(
                    @JsonProperty("result")
                    val result: List<String>?,
                    @JsonProperty("id")
                    val id: Int
            ) : Response()

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Error(
                    @JsonProperty("error")
                    val error: Error,
                    @JsonProperty("id")
                    val id: Int
            ) : Response() {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Error(
                        @JsonProperty("code")
                        val code: Int,
                        @JsonProperty("msg")
                        val msg: String
                ) : Response()
            }
        }
    }

    data class Request(
            @JsonProperty("method")
            val method: Method,
            @JsonProperty("params")
            val params: List<String>,
            @JsonProperty("id")
            val id: Int
    ) : WebSocketMessage()


    enum class Method {
        SUBSCRIBE, UNSUBSCRIBE, LIST_SUBSCRIPTIONS, SET_PROPERTY, GET_PROPERTY
    }
}