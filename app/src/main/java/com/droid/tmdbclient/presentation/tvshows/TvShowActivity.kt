package com.droid.tmdbclient.presentation.tvshows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.tmdbclient.R
import com.droid.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private val binding: ActivityTvShowBinding by lazy {
        ActivityTvShowBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)
    }
}