package com.droid.tmdbclient.presentation.di.movie

import com.droid.tmdbclient.presentation.di.artist.ArtistScope
import com.droid.tmdbclient.presentation.di.tvshow.TvShowModule
import com.droid.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(
    modules = [
        TvShowModule::class
    ]
)
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}
