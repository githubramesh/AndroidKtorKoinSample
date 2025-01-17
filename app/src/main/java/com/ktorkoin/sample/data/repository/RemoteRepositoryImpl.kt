package com.ktorkoin.sample.data.repository

import com.ktorkoin.sample.data.model.Movie
import com.ktorkoin.sample.data.model.MoviesResponse
import com.ktorkoin.sample.network.ApiService
import io.ktor.client.call.body

class RemoteRepositoryImpl(private val apiService: ApiService) : RemoteRepository {
    override suspend fun getMovies(): Result<List<Movie>> =
        runCatching {
            apiService.getMovies().body<MoviesResponse>().movies
        }
}