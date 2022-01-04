package com.ebdz.domain.model

data class Repository(
    val id: String,
    val name: String,
    val openGraphImageUrl: String,
    val stargazerCount: Int,
    val url: String,
    val shortDescriptionHTML: String
)
