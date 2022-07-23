package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapplication.R
import com.example.moviesapplication.feature_movies.domain.model.Movie

class MoviesAdapter(diffCallback: DiffUtil.ItemCallback<Movie>) : PagingDataAdapter<Movie, MovieViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.render(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(
            layoutInflater.inflate(R.layout.item_movie, parent, false)
        )
    }
}