package com.droid.tmdbclient.data.repository.tvshow.datasource

import com.droid.tmdbclient.data.model.tvshow.TvShow


interface TvShowCacheDataSource  {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(movies: List<TvShow>)

}