package com.droid.tmdbclient.presentation.di.tvshow

import com.droid.tmdbclient.presentation.di.artist.ArtistScope
import com.droid.tmdbclient.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(
    modules = [
        TvShowModule::class
    ]
)
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}
