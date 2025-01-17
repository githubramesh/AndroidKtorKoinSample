package com.ktorkoin.sample.data.repository

import com.ktorkoin.sample.data.model.Movie

interface RemoteRepository {
    suspend fun getMovies(): Result<List<Movie>>
}