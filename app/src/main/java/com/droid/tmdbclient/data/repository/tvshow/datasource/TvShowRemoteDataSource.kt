package com.droid.tmdbclient.data.repository.tvshow.datasource

import com.droid.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun  getTvShows(): Response<TvShowList>

}