package com.example.moviesapplication.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.squareup.picasso.Picasso

import com.squareup.picasso.OkHttp3Downloader




@HiltAndroidApp
class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this, Long.MAX_VALUE))
        val built = builder.build()
        built.setIndicatorsEnabled(true)
        built.isLoggingEnabled = true
        Picasso.setSingletonInstance(built)
    }
}