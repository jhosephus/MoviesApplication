package com.example.moviesapplication.feature_movies.data.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.example.moviesapplication.feature_movies.data.api.ImageApi
import com.example.moviesapplication.feature_movies.domain.repository.ImageRepository

class ImageRepositoryImpl constructor(
    private val imageApi: ImageApi
) : ImageRepository {
    override suspend fun getImage(path: String): Bitmap? {
        val response = imageApi.getImage(path = path)
        if (response.isSuccessful) {
            Log.d("IMAGE", "GET Success")
            val bytes = response.body()?.byteStream()
            val decodedBitmap = BitmapFactory.decodeStream(bytes)
            return decodedBitmap
        }
        Log.d("IMAGE", "GET Failure")
        Log.d("IMAGE", "Code: ${response.code()}")
        return null
    }
}