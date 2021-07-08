package com.reachnetwork.task.models.offers

import java.io.Serializable

data class Category(
    val id: Int,
    val name: String,
    val slug: String
):Serializable