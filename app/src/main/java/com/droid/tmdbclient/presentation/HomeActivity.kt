package com.droid.tmdbclient.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.tmdbclient.R
import com.droid.tmdbclient.databinding.ActivityHomeBinding
import com.droid.tmdbclient.presentation.artist.ArtistActivity
import com.droid.tmdbclient.presentation.movie.MovieActivity
import com.droid.tmdbclient.presentation.tvshows.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener {
         val intent = Intent(this,MovieActivity::class.java)
         startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}