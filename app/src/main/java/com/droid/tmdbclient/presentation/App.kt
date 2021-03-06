package com.droid.tmdbclient.presentation

import android.app.Application
import com.droid.tmdbclient.BuildConfig
import com.droid.tmdbclient.presentation.di.Injector
import com.droid.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.droid.tmdbclient.presentation.di.core.*
import com.droid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.droid.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}