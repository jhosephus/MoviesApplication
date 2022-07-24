package com.example.moviesapplication.feature_movies.domain.use_case.login_usecase

import com.example.moviesapplication.core.util.LoginUtil
import javax.inject.Inject

/**
 * LoginUseCase: It contains login business logic.
 *
 * It verifies if the credentials are valid (valid values are
 * hardcoded due to requirements).
 */

class LoginUseCase @Inject constructor() {

    fun invoke(user: String, password: String) : Boolean {
        return LoginUtil.validateCredentials(user, password)
    }
}