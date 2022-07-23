package com.example.moviesapplication.feature_movies.domain.model

data class MoviesPageResponse(
    val dates: DateInfo,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
