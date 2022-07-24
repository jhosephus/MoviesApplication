package com.example.moviesapplication.feature_movies.data.repository

import android.util.Log
import com.example.moviesapplication.feature_movies.data.api.MoviesApi
import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl constructor(
    private val moviesApi: MoviesApi
) : MoviesRepository {
    override suspend fun getMoviePage(page: Int): List<Movie> {
        val response = moviesApi.getMoviesPage(page = page)
        if (response.isSuccessful) {
            Log.d("MOVIES", "GET Success")
            return response.body()?.results ?: emptyList<Movie>()
        }
        Log.d("MOVIES", "GET Failure")
        Log.d("MOVIES", "Code: ${response.code()}")
        return emptyList<Movie>()
    }
}