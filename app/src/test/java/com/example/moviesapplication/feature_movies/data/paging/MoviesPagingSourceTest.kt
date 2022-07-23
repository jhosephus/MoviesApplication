package com.example.moviesapplication.feature_movies.data.paging

import androidx.paging.PagingSource
import com.example.moviesapplication.feature_movies.data.repository.FakeMoviesRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
//import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesPagingSourceTest {

    private val fakeRepo = FakeMoviesRepository()

    @Before
    fun setUp() {
    }

    @Test
    fun `test PagingSource load`() = runBlocking {
        val pagingSource = MoviesPagingSource(fakeRepo)
        assertThat(PagingSource.LoadResult.Page(
            data = fakeRepo.getMoviePage(1),
            prevKey = null,
            nextKey = 2
        )).isEqualTo(pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        ))
    }
}