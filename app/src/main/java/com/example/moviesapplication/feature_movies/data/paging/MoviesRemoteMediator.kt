package com.example.moviesapplication.feature_movies.data.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.moviesapplication.feature_movies.data.room.MoviesDatabase
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.domain.repository.ImageRepository
import com.example.moviesapplication.feature_movies.domain.repository.MoviesPageRepository
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ExperimentalPagingApi
class MoviesRemoteMediator @Inject constructor(
    private val db: MoviesDatabase,
    private val repo: MoviesRepository,
    private val imageRepository: ImageRepository,
    private val pageRepository: MoviesPageRepository
) : RemoteMediator<Int, MovieEntity>() {

    var currentPage = 1

    private val moviesDao = db.movieDao

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        return try {
            // The network load method takes an optional after=<user.id>
            // parameter. For every page after the first, pass the last user
            // ID to let it continue from where it left off. For REFRESH,
            // pass null to load the first page.

            var nextKey: Int? = 1
            when (loadType) {
                LoadType.REFRESH -> Log.d("Mediator", "Refresh")
                LoadType.PREPEND -> {
                    Log.d("Mediator", "Prepend")
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {
                    Log.d("Mediator", "Append")
                    /*if (state.anchorPosition != null) {
                        state.anchorPosition?.let { anchorPosition ->
                            val anchorPage = state.closestPageToPosition(anchorPosition)
                            Log.d("Mediator", "Anchor: ${anchorPage?.nextKey}")
                            nextKey = anchorPage?.nextKey?.plus(1) ?: 1
                        }
                    } else {
                        Log.d("Mediator", "Key preCalc: $nextKey and pages ${state.pages.size}")
                        nextKey = currentPage + 1
                    }*/
                    nextKey = currentPage + 1
                    if ((nextKey ?: 1) > 13) return MediatorResult.Success(endOfPaginationReached = true)
                }
            }

            // Suspending network load via Retrofit. This doesn't need to be
            // wrapped in a withContext(Dispatcher.IO) { ... } block since
            // Retrofit's Coroutine CallAdapter dispatches on a worker
            // thread.

            Log.d("Mediator", "Key: $nextKey")
            val response = pageRepository.getMoviePage(nextKey ?: 1)
            currentPage = response.page
            Log.d("Mediator", "CurrentPage: $currentPage")
            if (loadType == LoadType.REFRESH) {
                moviesDao.clearAll()
            }

            // Insert new users into database, which invalidates the
            // current PagingData, allowing Paging to present the updates
            // in the DB.
            if (response.results.isNotEmpty()) {
                moviesDao.insertMovies(response.results.map { it.toMovieEntity(imageRepository) })
                return MediatorResult.Success(endOfPaginationReached = false)
            }
            if ((nextKey ?: 1) > 13 || response.results.isEmpty()) {
                return MediatorResult.Success(endOfPaginationReached = true)
            }
            return MediatorResult.Success(
                endOfPaginationReached = true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}