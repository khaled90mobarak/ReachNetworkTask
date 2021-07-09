package com.reachnetwork.task.api

import com.reachnetwork.task.models.offers.OffersResponse
import com.reachnetwork.task.models.users.UsersResponse
import com.reachnetwork.task.utils.Constants.Companion.ID_OFFERS
import com.reachnetwork.task.utils.Constants.Companion.ID_USERS
import com.reachnetwork.task.utils.Constants.Companion.NAME_OFFERS
import com.reachnetwork.task.utils.Constants.Companion.Name_USERS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OffersApi {

    @GET("/api/v1/timeline")
    suspend fun getOffers(
        @Query("name")
        name: String = NAME_OFFERS,
        @Query("id")
        id: String = ID_OFFERS,

        ): Response<OffersResponse>

    @GET("/api/v1/categories")
    suspend fun getUsers(
        @Query("name")
        name: String = Name_USERS,
        @Query("id")
        id: String = ID_USERS,

        ): Response<UsersResponse>
}