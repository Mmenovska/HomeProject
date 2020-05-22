package com.android.gsixacademy.homeproject.tvShow

import com.android.gsixacademy.homeproject.models.DiscoverTvShowResult

sealed class DiscoverTvShowAdapterClickEvent {
    data class discoverTvShowAdapterItemClicked (var tvShowResult : DiscoverTvShowResult) : DiscoverTvShowAdapterClickEvent()

}
