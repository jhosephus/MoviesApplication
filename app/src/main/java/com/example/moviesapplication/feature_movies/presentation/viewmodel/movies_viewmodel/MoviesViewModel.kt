package com.example.moviesapplication.feature_movies.presentation.viewmodel.movies_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviesapplication.feature_movies.data.paging.MoviesPagingSource
import com.example.moviesapplication.feature_movies.data.paging.MoviesRemoteMediator
import com.example.moviesapplication.feature_movies.data.room.MoviesDatabase
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class MoviesViewModel
@Inject constructor(
    private val moviesPagingSource: MoviesPagingSource,
    moviesRemoteMediator: MoviesRemoteMediator,
    private val db: MoviesDatabase
) : ViewModel() {

    // Without caching
    val moviesFlow = Pager(PagingConfig(20)) {
        moviesPagingSource
    }.flow.cachedIn(viewModelScope)

    val selectedMovie = MutableLiveData<MovieEntity?>(null)

    // With caching
    val pager = Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = moviesRemoteMediator
    ) {
        db.movieDao.getMovies()
    }.flow.cachedIn(viewModelScope)


}