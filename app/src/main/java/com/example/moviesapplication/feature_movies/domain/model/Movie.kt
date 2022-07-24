package com.example.moviesapplication.feature_movies.domain.model

import android.util.Log
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.domain.repository.ImageRepository
import java.util.*

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Long>,
    val id: Long,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: Date,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Long
) {
    fun toMovieEntity(imageRepository: ImageRepository) : MovieEntity {
        Log.d("Movie", this.toString())
        return MovieEntity(
            adult = adult,
            backdrop_path = backdrop_path ?: "",
            genre_ids = genre_ids,
            id = id,
            original_language = original_language,
            original_title = original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path ?: "",
            release_date = release_date,
            title = title,
            video = video,
            vote_average = vote_average,
            vote_count = vote_count
        )
    }
}