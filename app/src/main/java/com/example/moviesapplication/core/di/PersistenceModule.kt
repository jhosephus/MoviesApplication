package com.example.moviesapplication.core.di

import android.app.Application
import androidx.room.Room
import com.example.moviesapplication.feature_movies.data.room.Converters
import com.example.moviesapplication.feature_movies.data.room.MoviesDatabase
import com.example.moviesapplication.feature_movies.data.util.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideCacheDatabase(app: Application) : MoviesDatabase {
        return Room.databaseBuilder(
            app, MoviesDatabase::class.java, "post_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

}