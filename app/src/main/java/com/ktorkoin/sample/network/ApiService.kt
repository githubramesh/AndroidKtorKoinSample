package com.ktorkoin.sample.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT = "http://demo8912703.mockable.io/"
        private const val GET_MOVIES_ENDPOINT = "movies"
    }

    suspend fun getMovies() = client.get("$END_POINT$GET_MOVIES_ENDPOINT")
}