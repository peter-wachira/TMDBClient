package com.droid.tmdbclient.presentation.di.core

import com.droid.tmdbclient.data.db.ArtistDao
import com.droid.tmdbclient.data.db.MovieDao
import com.droid.tmdbclient.data.db.TvShowDao
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.droid.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.droid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.droid.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(
        movieDao: MovieDao
    ): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(
        artistDao: ArtistDao
    ): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(
        tvShowDao: TvShowDao
    ): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}