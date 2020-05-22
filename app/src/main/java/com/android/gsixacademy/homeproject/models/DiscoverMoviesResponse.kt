package com.android.gsixacademy.homeproject.models

class DiscoverMoviesResponse(
    val page : Int?,
    val total_results : Int?,
    val total_pages : Int?,
    val results : ArrayList <DiscoverMoviesResult>
)