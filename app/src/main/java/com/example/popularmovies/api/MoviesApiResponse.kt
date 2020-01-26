package com.example.popularmovies.api

import com.example.popularmovies.model.Movie
import com.google.gson.annotations.SerializedName

data class MoviesApiResponse(@SerializedName("results") var movies: List<Movie>)