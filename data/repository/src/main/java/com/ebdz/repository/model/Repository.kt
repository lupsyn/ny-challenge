package com.ebdz.repository.model

data class Repository(
    val id: String,
    val name: String,
    val openGraphImageUrl: String,
    val stargazerCount: Int,
    val url: String,
    val shortDescriptionHTML: String
)
