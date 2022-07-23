package com.example.moviesapplication.feature_movies.presentation.viewmodel.login_viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.feature_movies.domain.repository.ImageRepository
import com.example.moviesapplication.feature_movies.domain.use_case.login_usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val successfulLogin = MutableLiveData<Boolean?>(null)

    fun onEvent(loginEvent: LoginEvent) {
        when(loginEvent) {
            is LoginEvent.LoginAttempt -> {
                successfulLogin.postValue(loginUseCase.invoke(loginEvent.user, loginEvent.password))
            }
        }
    }
}