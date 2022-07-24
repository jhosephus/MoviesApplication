package com.example.moviesapplication.feature_movies.data.repository

import android.util.Log
import com.example.moviesapplication.feature_movies.data.api.MoviesApi
import com.example.moviesapplication.feature_movies.domain.model.DateInfo
import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.example.moviesapplication.feature_movies.domain.model.MoviesPageResponse
import com.example.moviesapplication.feature_movies.domain.repository.MoviesPageRepository
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository
import java.util.*

class MoviesPageRepositoryImpl constructor(
    private val moviesApi: MoviesApi
) : MoviesPageRepository {

    val dummyPageResponse = MoviesPageResponse(
        dates = DateInfo(Date(0L), Date(0L)),
        page = 1,
        results = emptyList<Movie>(),
        total_pages = 13,
        total_results = 247
    )

    override suspend fun getMoviePage(page: Int): MoviesPageResponse {
        val response = moviesApi.getMoviesPage(page = page)
        if (response.isSuccessful) {
            Log.d("MOVIES", "GET Success")
            return response.body() ?: dummyPageResponse
        }
        Log.d("MOVIES", "GET Failure")
        Log.d("MOVIES", "Code: ${response.code()}")
        return dummyPageResponse
    }
}