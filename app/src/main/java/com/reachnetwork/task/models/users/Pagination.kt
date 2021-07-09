package com.reachnetwork.task.models.users

data class Pagination(
    val count: Int,
    val current_page: Int,
    val links: Any,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)