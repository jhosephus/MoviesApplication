package com.example.moviesapplication.feature_movies.domain.repository

import com.example.moviesapplication.feature_movies.domain.model.Movie

interface MoviesRepository {

    suspend fun getMoviePage(page: Int) : List<Movie>
}