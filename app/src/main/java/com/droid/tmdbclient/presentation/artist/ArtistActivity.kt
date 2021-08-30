package com.droid.tmdbclient.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.droid.tmdbclient.R
import com.droid.tmdbclient.databinding.ActivityArtistBinding
import com.droid.tmdbclient.presentation.di.Injector
import com.droid.tmdbclient.utils.extensions.hide
import com.droid.tmdbclient.utils.extensions.show
import com.droid.tmdbclient.utils.extensions.showErrorSnackbar
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    private val binding: ActivityArtistBinding by lazy {
        ActivityArtistBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (application as Injector).createArtistSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        initRecyclerview()
    }

    private fun initRecyclerview() {
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        getArtists()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_update -> {
                updateArtists()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateArtists() {
        val response = viewModel.updateArtists()
        response.observe(this, {
            binding.artistProgressBar.show()
            if (it != null) {
                adapter.submitList(it.toMutableList())
                binding.artistProgressBar.hide()
            } else {
                binding.artistProgressBar.hide()
                binding.root.showErrorSnackbar("No Data Available", Snackbar.LENGTH_LONG)
            }
        })
    }


    private fun getArtists() {
        val response = viewModel.getArtists()
        response.observe(this, {
            binding.artistProgressBar.show()
            if (it != null) {
                adapter.submitList(it.toMutableList())
                binding.artistProgressBar.hide()
            } else {
                binding.artistProgressBar.hide()
                binding.root.showErrorSnackbar("No Data Available", Snackbar.LENGTH_LONG)
            }
        })
    }


}