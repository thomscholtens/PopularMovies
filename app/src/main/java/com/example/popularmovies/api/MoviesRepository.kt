package com.example.popularmovies.api

import com.example.popularmovies.api.MoviesApi
import com.example.popularmovies.api.MoviesApiService

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMoviesFromYear(year: String) = moviesApi.getMoviesFromYear(year)
}