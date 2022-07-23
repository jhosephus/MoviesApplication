package com.example.moviesapplication.feature_movies.presentation.viewmodel.login_viewmodel

sealed class LoginEvent {
    data class LoginAttempt(val user: String, val password: String) : LoginEvent()
}