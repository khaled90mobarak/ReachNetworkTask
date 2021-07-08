package com.reachnetwork.task.repository

import com.reachnetwork.task.api.RetrofitInstance

class TaskRepository {

    suspend fun getOffers() =
        RetrofitInstance.api.getOffers()

}