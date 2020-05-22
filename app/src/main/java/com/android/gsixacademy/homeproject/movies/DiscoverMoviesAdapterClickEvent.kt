package com.android.gsixacademy.homeproject.movies

import com.android.gsixacademy.homeproject.models.DiscoverMoviesResult

sealed class DiscoverMoviesAdapterClickEvent {
    data class DiscoverMoviesItemClicked (var movieResult : DiscoverMoviesResult) : DiscoverMoviesAdapterClickEvent()
}