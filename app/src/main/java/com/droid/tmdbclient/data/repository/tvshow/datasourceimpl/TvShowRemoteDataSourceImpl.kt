package com.droid.tmdbclient.data.repository.tvshow.datasourceimpl

import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.tvshow.TvShowList
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDatasource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}