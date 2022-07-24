package com.example.moviesapplication.feature_movies.presentation.screen.detail_screen

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.paging.ExperimentalPagingApi
import com.example.moviesapplication.R
import com.example.moviesapplication.core.common.UrlProvider
import com.example.moviesapplication.databinding.FragmentDetailBinding
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.presentation.viewmodel.movies_viewmodel.MoviesViewModel
import com.squareup.picasso.Picasso

@ExperimentalPagingApi
class DetailFragment : Fragment() {

    // Binding
    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val moviesViewModel : MoviesViewModel by activityViewModels()

    // Navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        moviesViewModel.selectedMovie.observe(requireActivity(), Observer { movie ->
            movie?.let {
                setMovieDetails(it)
            }
        })

    }

    private fun setMovieDetails(movie: MovieEntity) {
        Picasso
            .get()
            .load("${UrlProvider.imagesUrl}${movie.poster_path}")
            .placeholder(R.drawable.ic_loading_poster)
            .resize(200, 200)
            .centerInside()
            .error(R.drawable.ic_poster_not_found)
            .into(binding.ivVerticalPoster)
        binding.tvTitle.text = movie.title
        binding.tvRating.text = movie.vote_average.toString()
        binding.tvReleaseDate.text = DateFormat.format("yyyy-MM-dd", movie.release_date).toString()
        binding.tvSummary.text = movie.overview
    }
}