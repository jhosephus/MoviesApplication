package com.example.moviesapplication.feature_movies.presentation.viewmodel.movies_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviesapplication.feature_movies.data.paging.MoviesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesPagingSource: MoviesPagingSource
) : ViewModel() {

    val moviesFlow = Pager(PagingConfig(20)) {
        moviesPagingSource
    }.flow.cachedIn(viewModelScope)

}