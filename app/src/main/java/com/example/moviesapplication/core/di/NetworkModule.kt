package com.example.moviesapplication.core.di

import com.example.moviesapplication.core.common.UrlProvider
import com.example.moviesapplication.feature_movies.data.api.ImageApi
import com.example.moviesapplication.feature_movies.data.api.MoviesApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * This Hilt module provides:
 * ... a retrofit instance
 * ... apis instance
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("movies")
    fun providesRetrofitMovies() : Retrofit {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()
        return Retrofit.Builder()
            .baseUrl(UrlProvider.moviesUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    @Named("images")
    fun providesRetrofitImages() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(UrlProvider.imagesUrl)
            .build()
    }

    @Provides
    @Singleton
    fun providesMoviesApi(@Named("movies") retrofit: Retrofit) : MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesImageApi(@Named("images") retrofit: Retrofit) : ImageApi {
        return retrofit.create(ImageApi::class.java)
    }

}