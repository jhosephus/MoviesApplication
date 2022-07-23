package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.databinding.ItemMovieBinding
import com.example.moviesapplication.feature_movies.domain.model.Movie

class MovieViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemMovieBinding.bind(itemView)

    fun render(movie: Movie?) {
        if (movie != null) {
            binding.tvTitle.text = movie.original_title
        } else {
            binding.tvTitle.text = "Movie not found"
        }
    }
}