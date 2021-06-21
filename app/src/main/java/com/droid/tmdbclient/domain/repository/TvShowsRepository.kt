package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.tvshow.TvShow


interface  TvShowsRepository {
    suspend fun  getTvShows():List<TvShow>?
    suspend fun  updateTvShows():List<TvShow>?

}
