package com.example.popularmovies.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popularmovies.api.MoviesApiResponse
import com.example.popularmovies.api.MoviesRepository
import com.example.popularmovies.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MoviesRepository()
    val movies = MutableLiveData<List<Movie>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    /**
     * Get a random number trivia from the repository using Retrofit.
     * onResponse if the response is successful populate the [Movie] object.
     * If the call encountered an error then populate the [error] object.
     */
    fun getMoviesForYear(year: String) {
        loading.value = true
        movieRepository.getMoviesFromYear(year).enqueue(object : Callback<MoviesApiResponse> {
            override fun onResponse(call: Call<MoviesApiResponse>, response: Response<MoviesApiResponse>) {
                if (response.isSuccessful) movies.value = response.body()?.movies
                else error.value = response.errorBody().toString()
                loading.value = false
            }

            override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {
                error.value = t.message
                loading.value = false
            }
        })
    }
}