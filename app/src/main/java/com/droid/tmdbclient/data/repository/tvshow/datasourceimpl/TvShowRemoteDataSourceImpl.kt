package com.droid.tmdbclient.data.repository.tvshow.datasourceimpl

import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.tvshow.TvShowList
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}