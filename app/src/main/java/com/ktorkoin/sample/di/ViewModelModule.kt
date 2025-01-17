package com.ktorkoin.sample.di

import com.ktorkoin.sample.ui.movie.MovieViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}