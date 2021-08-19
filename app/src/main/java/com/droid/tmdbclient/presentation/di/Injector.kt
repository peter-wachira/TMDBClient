package com.droid.tmdbclient.presentation.di

import com.droid.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.droid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.droid.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}