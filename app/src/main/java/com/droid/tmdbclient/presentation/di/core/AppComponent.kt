package com.droid.tmdbclient.presentation.di.core

import com.droid.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.droid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.droid.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artsitSubComponent(): ArtistSubComponent.Factory

}