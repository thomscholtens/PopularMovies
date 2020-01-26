package com.example.popularmovies.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val KEY = "a7aa4aaf3b90a9179efd59e098d0ac3c"

public interface MoviesApiService {

    // The GET method needed to retrieve a random number trivia.
    @GET("discover/movie?api_key=$KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&")
    fun getMoviesFromYear(@Query("primary_release_year") year: String): Call<MoviesApiResponse>

}