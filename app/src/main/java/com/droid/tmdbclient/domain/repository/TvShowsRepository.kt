package com.droid.tmdbclient.domain.repository

import com.droid.tmdbclient.data.model.tvshow.TvShow


interface  TvShowsRepository {
    suspend fun  getTvShows():List<TvShow>?
    suspend fun  updateTvShows():List<TvShow>?

}
