package com.example.moviesapplication.core.di

import com.example.moviesapplication.feature_movies.data.api.MoviesApi
import com.example.moviesapplication.feature_movies.data.repository.MoviesRepositoryImpl
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesMoviesRepository(moviesApi: MoviesApi) : MoviesRepository {
        return MoviesRepositoryImpl(moviesApi)
    }

}