package com.burhan.common.data.remote.api

import com.burhan.common.data.remote.model.BitCoinResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("bpi/currentprice.json")
    fun downloadBitCoinPriceAsync(): Deferred<Response<BitCoinResponse>>

}