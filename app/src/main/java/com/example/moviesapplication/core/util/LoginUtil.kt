package com.example.moviesapplication.core.util

object LoginUtil {

    fun validateCredentials(user: String, password: String): Boolean {
        if (user != "User") return false
        if (password != "Password*123") return false
        return true
    }

}