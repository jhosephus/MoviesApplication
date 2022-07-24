package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapplication.R
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity

class MoviesAdapter(
    diffCallback: DiffUtil.ItemCallback<MovieEntity>,
    private val movieItemListener: MovieItemListener
)
    : PagingDataAdapter<MovieEntity, MovieViewHolder>(
    diffCallback
) {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("MovieAdapter", item.toString())
        holder.render(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(
            layoutInflater.inflate(R.layout.item_movie, parent, false),
            movieItemListener = movieItemListener
        )
    }
}