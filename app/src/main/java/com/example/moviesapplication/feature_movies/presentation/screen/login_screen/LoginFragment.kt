package com.example.moviesapplication.feature_movies.presentation.screen.login_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    // Binding
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // Navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}