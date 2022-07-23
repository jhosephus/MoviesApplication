package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.R
import com.example.moviesapplication.core.common.UrlProvider
import com.example.moviesapplication.databinding.ItemMovieBinding
import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemMovieBinding.bind(itemView)

    fun render(movie: Movie?) {
        if (movie != null) {
            Picasso
                .get()
                .load("${UrlProvider.imagesUrl}${movie.backdrop_path}")
                .placeholder(R.drawable.ic_loading_poster)
                .fit()
                .error(R.drawable.ic_poster_not_found)
                .into(binding.ivBackdropPoster)
            binding.tvTitle.text = movie.original_title
        } else {
            binding.tvTitle.text = "Movie not found"
        }
    }
}