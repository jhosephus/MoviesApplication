package com.example.moviesapplication.feature_movies.presentation.screen.movies_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapplication.databinding.FragmentMoviesBinding
import com.example.moviesapplication.feature_movies.data.room.entity.MovieEntity
import com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list.MovieItemListener
import com.example.moviesapplication.feature_movies.presentation.screen.movies_screen.components.list.MoviesAdapter
import com.example.moviesapplication.feature_movies.presentation.viewmodel.movies_viewmodel.MoviesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * LoginScreen: It contains one control:
 * ... Movies recyclerView
 *
 * Logic: It consults business logic for the list of movies.
 * It launches a coroutine to receive the incoming data and display in list.
 */

@ExperimentalPagingApi
class MoviesFragment : Fragment() {

    // Binding
    private var _binding : FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val moviesViewModel : MoviesViewModel by activityViewModels()

    // Navigation
    private lateinit var navController: NavController

    // RecyclerView Adapter
    private val moviesAdapter = MoviesAdapter(object : DiffUtil.ItemCallback<MovieEntity>() {
        override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
            return oldItem == newItem
        }

    }, object : MovieItemListener {
        override fun onMovieItemClick(movie: MovieEntity) {
            moviesViewModel.selectedMovie.postValue(movie)
            navController.navigate(MoviesFragmentDirections.actionMoviesFragmentToDetailFragment())
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.rvMovies.layoutManager = LinearLayoutManager(activity)
        binding.rvMovies.adapter = moviesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.pager.collectLatest { pagingData ->
                moviesAdapter.submitData(pagingData = pagingData)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            moviesAdapter.loadStateFlow.collectLatest { loadState ->
                if (loadState.refresh is LoadState.Loading) {
                    binding.pbLoadingCircle.visibility = View.VISIBLE
                } else {
                    binding.pbLoadingCircle.visibility = View.GONE
                }
            }
        }

    }
}