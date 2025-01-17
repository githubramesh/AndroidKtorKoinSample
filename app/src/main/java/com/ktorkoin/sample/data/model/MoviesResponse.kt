package com.ktorkoin.sample.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("movies")
    val movies: List<Movie>
)
