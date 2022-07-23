package com.example.moviesapplication.feature_movies.domain.repository

import android.graphics.Bitmap

interface ImageRepository {

    suspend fun getImage(path: String) : Bitmap?
}