package com.droid.tmdbclient.presentation.di.core

import com.droid.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.droid.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.droid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.droid.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }


}