package com.android.gsixacademy.homeproject.api

import com.android.gsixacademy.homeproject.models.DiscoverMoviesResponse
import com.android.gsixacademy.homeproject.models.DiscoverTvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBApi {

    @GET ("/3/discover/movie")
    fun getMovies (@Query ("api_key") key : String) : Call<DiscoverMoviesResponse>

    @GET ("/3/discover/tv")
    fun getTvShow (@Query ("api_key") key : String) : Call <DiscoverTvShowResponse>

    @GET ("/3/search/movie")
    fun searchMovies (@Query("api_key") key : String, @Query ("query") query : String) : Call <DiscoverMoviesResponse>

    @GET ("/3/search/tv")
    fun searchTvShow (@Query ("api_key") key : String, @Query ("query") query : String) : Call <DiscoverTvShowResponse>
}