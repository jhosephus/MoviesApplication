package com.example.moviesapplication.feature_movies.data.repository

import com.example.moviesapplication.feature_movies.domain.model.Movie
import com.example.moviesapplication.feature_movies.domain.repository.MoviesRepository
import java.util.*

class FakeMoviesRepository : MoviesRepository {

    override suspend fun getMoviePage(page: Int): List<Movie> {
        val page1 = listOf(
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli1", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli2", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli3", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli4", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli5", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli6", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli7", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli8", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli9", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli10", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli11", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli12", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli13", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli14", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli15", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli16", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli17", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli18", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli19", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli20", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L)
        )
        val page2 = listOf(
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli21", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli22", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli23", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli24", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli25", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli26", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli27", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli28", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli29", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli30", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli31", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli32", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli33", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli34", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli35", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli36", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli37", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli38", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli39", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L),
            Movie(false, "image1", listOf(1L,2L), 1L, "en", "Peli40", "Resumen", 0.75, "image2", Date(1L), "title", false, 3.5, 1L)
        )
        return if (page == 1) page1 else page2
    }
}