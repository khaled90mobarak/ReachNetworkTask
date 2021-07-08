package com.reachnetwork.task.models.offers

import java.io.Serializable

data class User(
    val background_image: Any,
    val cover_photo: Any,
    val id: Int,
    val name: String,
    val `object`: String,
    val phone_background: Any,
    val profile_picture: String,
    val username: String
):Serializable