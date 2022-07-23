package com.example.moviesapplication.feature_movies.domain.use_case.login_usecase

import com.example.moviesapplication.core.util.LoginUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginUseCaseTest {

    @Test
    fun `user is not "User", return false`() {
        val validationResult = LoginUtil.validateCredentials(
            user = "a",
            password = "Password*123"
        )
        assertThat(validationResult).isFalse()
    }

    @Test
    fun `password is not "Password*123", returns false`() {
        val validationResult = LoginUtil.validateCredentials(
            user = "User",
            password = "a"
        )
        assertThat(validationResult).isFalse()
    }

    @Test
    fun `"User" and "Password*123", returns true`() {
        val validationResult = LoginUtil.validateCredentials(
            user = "User",
            password = "Password*123"
        )
        assertThat(validationResult).isTrue()
    }

}