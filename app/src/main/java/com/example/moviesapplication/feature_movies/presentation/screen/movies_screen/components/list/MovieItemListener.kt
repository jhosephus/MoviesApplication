package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity

interface MovieItemListener {

    fun onMovieItemClick(movie: MovieEntity)

}