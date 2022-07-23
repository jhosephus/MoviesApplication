package com.example.moviesapplication.feature_movies.data.room

import android.R.attr
import android.graphics.Bitmap
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.moviesapplication.feature_movies.data.util.JsonParser
import java.util.*
import android.R.attr.bitmap
import android.graphics.BitmapFactory
import java.nio.ByteBuffer


@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromGenresJson(json: String): List<Long> {
        return jsonParser
            .fromJson<List<Long>>(
                json,
                List::class.java) ?:
                emptyList<Long>()
    }

    @TypeConverter
    fun fromJsonGenres(genres: List<Long>): String {
        return jsonParser
            .toJson<List<Long>>(
                genres,
                List::class.java
            ) ?: ""
    }

    @TypeConverter
    fun fromDateLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongDate(time: Long): Date {
        return Date(time)
    }

    @TypeConverter
    fun fromBitmapArray(bitmap: Bitmap): ByteArray {
        val width = bitmap.width
        val height = bitmap.height

        val size: Int = bitmap.rowBytes * height
        val byteBuffer: ByteBuffer = ByteBuffer.allocate(size)
        bitmap.copyPixelsToBuffer(byteBuffer)
        return byteBuffer.array()
    }

    @TypeConverter
    fun fromArrayBitmap(biteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(biteArray, 0, biteArray.size)
    }

}