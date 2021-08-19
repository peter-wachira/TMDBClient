package com.droid.tmdbclient.presentation.di.core

import com.droid.tmdbclient.data.repository.ArtistRepositoryImpl
import com.droid.tmdbclient.data.repository.TvShowRepositoryImpl
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.droid.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.droid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.droid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.droid.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.droid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.droid.tmdbclient.domain.repository.ArtistRepository
import com.droid.tmdbclient.domain.repository.MovieRepository
import com.droid.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providetvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}