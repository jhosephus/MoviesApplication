package com.example.moviesapplication.feature_movies.presentation.screen.login_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentLoginBinding
import com.example.moviesapplication.feature_movies.presentation.viewmodel.login_viewmodel.LoginEvent
import com.example.moviesapplication.feature_movies.presentation.viewmodel.login_viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    // Binding
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val loginViewModel : LoginViewModel by activityViewModels()

    // Navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        loginViewModel.successfulLogin.observe(requireActivity(), Observer { success ->
            success?.let {
                if (!it) {
                    Toast.makeText(activity, "Invalid credentials", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "Entering", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btSignIn.setOnClickListener {
            loginViewModel.onEvent(
                LoginEvent.LoginAttempt(
                    user = binding.etUser.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            )
        }
    }
}