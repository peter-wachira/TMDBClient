package com.droid.tmdbclient.presentation.tvshows

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.droid.tmdbclient.R
import com.droid.tmdbclient.databinding.ActivityTvShowBinding
import com.droid.tmdbclient.presentation.di.Injector
import com.droid.tmdbclient.utils.extensions.hide
import com.droid.tmdbclient.utils.extensions.show
import com.droid.tmdbclient.utils.extensions.showErrorSnackbar
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

    private val binding: ActivityTvShowBinding by lazy {
        ActivityTvShowBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerview()
    }

    private fun initRecyclerview() {
        adapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter
        displayTvShows()

    }

    private fun displayTvShows() {
        binding.tvshowProgressBar.show()
        val response = tvShowViewModel.getTvShows()
        response.observe(this, {
            if (it != null) {
                adapter.submitList(it.toMutableList())
                binding.tvshowProgressBar.hide()
            } else {
                binding.tvshowProgressBar.hide()
                binding.tvshowRecyclerView.showErrorSnackbar(
                    "No Data Available",
                    Snackbar.LENGTH_LONG
                )
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateShows()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateShows() {
        binding.tvshowProgressBar.show()
        val response = tvShowViewModel.updateShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.submitList(it.toMutableList())
                binding.tvshowProgressBar.hide()
            } else {
                binding.tvshowProgressBar.hide()
                binding.tvshowRecyclerView.showErrorSnackbar(
                    "No Data Available",
                    Snackbar.LENGTH_LONG
                )
            }
        })
    }

}