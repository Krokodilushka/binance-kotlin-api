# Binance Kotlin API
Websocket, spot trading, margin trading, isolated margin trading.

[![Release](https://jitpack.io/v/Krokodilushka/binance-kotlin-api.svg)](https://jitpack.io/#Krokodilushka/binance-kotlin-api)

Endpoints:
1. Market data ([docs](https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints "docs") | [examples](https://github.com/Krokodilushka/binance-kotlin-api/blob/master/src/test/kotlin/com/binance/api/examples/RestMarketDataEndpointsExample.kt "examples"))
2. Spot ([docs](https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade "docs") | [examples](https://github.com/Krokodilushka/binance-kotlin-api/blob/master/src/test/kotlin/com/binance/api/examples/RestSpotEndpointsExample.kt "examples"))
3. Margin ([docs](https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade "docs") | [examples](https://github.com/Krokodilushka/binance-kotlin-api/blob/master/src/test/kotlin/com/binance/api/examples/RestMarginEndpointsExample.kt "examples"))

Websocket:
1. Market Streams ([docs](https://binance-docs.github.io/apidocs/spot/en/#websocket-market-streams "docs") | [examples](https://github.com/Krokodilushka/binance-kotlin-api/blob/master/src/test/kotlin/com/binance/api/examples/WebSocketMarketDataExample.kt "examples"))
2. User Data Streams ([docs](https://binance-docs.github.io/apidocs/spot/en/#user-data-streams "docs") | [examples](https://github.com/Krokodilushka/binance-kotlin-api/blob/master/src/test/kotlin/com/binance/api/examples/WebSocketUserDataExample.kt "examples"))

## Installation
Gradle:
```groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
    ...
}
dependencies {
    ...
    compile 'com.github.Krokodilushka:binance-kotlin-api:xxx' // See the `JitPack` badge
    ...
}
```
