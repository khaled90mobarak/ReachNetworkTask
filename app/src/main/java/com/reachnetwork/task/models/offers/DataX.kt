package com.reachnetwork.task.models.offers

import java.io.Serializable

data class DataX(
    val banner_image: String,
    val categories: List<Category>,
    val cover_image: String,
    val cta: String,
    val cta_background_color: String,
    val cta_text_color: String,
    val cta_url: String,
    val due_date: String,
    val id: Int,
    val title: String,
    val user: User
): Serializable