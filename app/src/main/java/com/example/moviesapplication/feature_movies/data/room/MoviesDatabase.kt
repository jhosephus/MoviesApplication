package com.example.moviesapplication.feature_movies.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviesapplication.feature_movies.data.room.dao.MovieDao
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
)
@TypeConverters(Converters::class)
abstract class MoviesDatabase : RoomDatabase() {

    abstract val movieDao : MovieDao

}