package com.burhan.common.data.remote.dummy

import com.burhan.common.data.remote.model.BitCoinDTO
import com.burhan.common.data.remote.model.BitCoinResponse
import com.google.gson.Gson

object DummyData {
    fun dummyBitCoinPrice(): BitCoinDTO =
        Gson().fromJson(
            "{\"time\":{\"updated\":\"Jan 15, 2021 08:46:00 UTC\",\"updatedISO\":\"2021-01-15T08:46:00+00:00\",\"updateduk\":\"Jan 15, 2021 at 08:46 GMT\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"chartName\":\"Bitcoin\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"symbol\":\"&#36;\",\"rate\":\"38,471.0783\",\"description\":\"United States Dollar\",\"rate_float\":38471.0783},\"GBP\":{\"code\":\"GBP\",\"symbol\":\"&pound;\",\"rate\":\"28,158.1364\",\"description\":\"British Pound Sterling\",\"rate_float\":28158.1364},\"EUR\":{\"code\":\"EUR\",\"symbol\":\"&euro;\",\"rate\":\"31,702.7076\",\"description\":\"Euro\",\"rate_float\":31702.7076}}}",
            BitCoinResponse::class.java
        ).bpi

}