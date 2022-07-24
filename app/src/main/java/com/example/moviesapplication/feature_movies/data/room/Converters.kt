package com.example.moviesapplication.feature_movies.data.room

import android.graphics.Bitmap
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.moviesapplication.feature_movies.data.util.JsonParser
import java.util.*
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream


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
    fun fromBitmapArray(bitmap: Bitmap?): ByteArray? {
        if (bitmap != null) {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream)
            return stream.toByteArray()
        }
        return null
    }

    @TypeConverter
    fun fromArrayBitmap(biteArray: ByteArray?): Bitmap? {
        if (biteArray != null) {
            return BitmapFactory.decodeByteArray(biteArray, 0, biteArray.size)
        }
        return null
    }

}