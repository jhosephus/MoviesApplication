package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.domain.model.Movie

interface MovieItemListener {

    //fun onMovieItemClick(movie: Movie)

    fun onMovieItemClick(movie: MovieEntity)

}