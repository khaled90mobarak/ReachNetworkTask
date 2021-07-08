package com.reachnetwork.task.api

import com.reachnetwork.task.models.offers.OffersResponse
import com.reachnetwork.task.utils.Constants.Companion.ID
import com.reachnetwork.task.utils.Constants.Companion.NAME
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OffersApi {

    @GET("/api/v1/timeline")
    suspend fun getOffers(
        @Query("name")
        name: String = NAME,
        @Query("id")
        id: String = ID,

    ): Response<OffersResponse>
}