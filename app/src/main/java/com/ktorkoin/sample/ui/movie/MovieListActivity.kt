package com.ktorkoin.sample.ui.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ktorkoin.sample.ui.components.MovieItem
import com.ktorkoin.sample.ui.theme.AndroidKtorKoinSampleTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidKtorKoinSampleTheme {
                val viewModel: MovieViewModel by viewModel()
                val movieItems by viewModel.moviesList.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit, block = {
                    viewModel.loadMovies()
                })

                Scaffold { innerPaddings ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPaddings),
                        verticalArrangement = Arrangement.SpaceBetween, content = {
                            items(movieItems) {
                                MovieItem(item = it)
                            }
                        })
                }
            }
        }
    }
}



