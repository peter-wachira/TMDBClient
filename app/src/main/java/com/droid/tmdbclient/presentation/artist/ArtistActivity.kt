package com.droid.tmdbclient.presentation.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.tmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private val binding: ActivityArtistBinding by lazy {
        ActivityArtistBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}