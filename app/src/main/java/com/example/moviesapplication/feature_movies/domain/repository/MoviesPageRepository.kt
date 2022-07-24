package com.example.moviesapplication.feature_movies.domain.repository

import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.example.moviesapplication.feature_movies.domain.model.MoviesPageResponse

interface MoviesPageRepository {

    suspend fun getMoviePage(page: Int) : MoviesPageResponse
}