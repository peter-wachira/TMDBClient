package com.droid.tmdbclient.data.repository.tvshow.datasourceimpl

import com.droid.tmdbclient.data.db.MovieDao
import com.droid.tmdbclient.data.db.TvShowDao
import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.data.model.tvshow.TvShow
import com.droid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return  tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }

}