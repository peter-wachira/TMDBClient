package com.droid.tmdbclient.presentation.di.artist

import com.droid.tmdbclient.presentation.artist.ArtistActivity
import com.droid.tmdbclient.presentation.di.movie.MovieSubComponent
import dagger.Subcomponent

@ArtistScope
@Subcomponent(
    modules = [
        ArtistModule::class
    ]
)
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}
