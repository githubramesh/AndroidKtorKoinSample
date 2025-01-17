package com.ktorkoin.sample.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int? = null,
    val name: String? = null,
    val imageUrl: String? = null
)
