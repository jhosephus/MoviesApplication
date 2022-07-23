package com.example.moviesapplication.feature_movies.data.api

import com.example.moviesapplication.BuildConfig
import com.example.moviesapplication.feature_movies.domain.model.MoviesPageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/upcoming")
    @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
    suspend fun getMoviesPage(
        @Query("page") page: Int
    ) : Response<MoviesPageResponse>
}