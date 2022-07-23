package com.example.moviesapplication.feature_movies.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviesapplication.feature_movies.data.api.MoviesApi
import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesPagingSource @Inject constructor(
    private val moviesRepository: MoviesRepository
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = moviesRepository.getMoviePage(nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}