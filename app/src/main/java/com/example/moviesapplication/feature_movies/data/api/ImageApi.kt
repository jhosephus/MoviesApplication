package com.example.moviesapplication.feature_movies.data.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {

    @GET("{path}")
    suspend fun getImage(
        @Path("path") path: String
    ) : Response<ResponseBody>

}