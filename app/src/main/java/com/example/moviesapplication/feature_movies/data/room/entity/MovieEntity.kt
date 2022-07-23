package com.example.moviesapplication.feature_movies.data.room.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MovieEntity(
    val adult: Boolean,
    val backdrop_bitmap: Bitmap,
    val genre_ids: List<Long>,
    @PrimaryKey val id: Long,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_bitmap: Bitmap,
    val release_date: Date,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Long

)
