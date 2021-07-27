package com.droid.tmdbclient.presentation.di.artist

import com.droid.tmdbclient.domain.usecase.GetArtistsUseCase
import com.droid.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.droid.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}