package com.ktorkoin.sample.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktorkoin.sample.data.model.Movie
import com.ktorkoin.sample.data.repository.RemoteRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModel() {
    private val _moviesList: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val moviesList: StateFlow<List<Movie>> = _moviesList

    fun loadMovies() {
        viewModelScope.launch {
            remoteRepositoryImpl.getMovies().fold(
                onSuccess = { movies ->
                    _moviesList.update { movies }
                }, onFailure = {
                    println("onFailure: $it")
                })
        }
    }
}

