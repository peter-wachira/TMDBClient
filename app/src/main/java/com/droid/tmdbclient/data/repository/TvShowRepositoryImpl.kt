package com.droid.tmdbclient.data.repository

import android.util.Log
import com.droid.tmdbclient.data.model.tvshow.TvShow
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.droid.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getMoviesFromCache()

    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }


    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getMoviesFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
            if (tvShowList.isNotEmpty()) {
                return tvShowList
            } else {
                tvShowList = getTvShowsFromAPI()
                tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
            }
        }

        return tvShowList
    }

    suspend fun getMoviesFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }


}