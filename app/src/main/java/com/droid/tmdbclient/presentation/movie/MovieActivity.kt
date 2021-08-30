package com.droid.tmdbclient.presentation.movie


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.droid.tmdbclient.R
import com.droid.tmdbclient.databinding.ActivityMovieBinding
import com.droid.tmdbclient.presentation.di.Injector
import com.droid.tmdbclient.utils.extensions.hide
import com.droid.tmdbclient.utils.extensions.show
import com.droid.tmdbclient.utils.extensions.showErrorSnackbar
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    private val binding: ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (application as Injector).createMovieSubComponent()
            .inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        initRecycler()

    }


    private fun initRecycler() {
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayMovies()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }


    private fun updateMovies() {
        binding.movieProgressBar.show()
        val response = movieViewModel.updateMovies()
        response.observe(this, {
            if (it != null) {
                adapter.submitList(it.toMutableList())
                binding.movieProgressBar.hide()
            }
        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayMovies() {
        binding.movieProgressBar.show()
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.submitList(it.toMutableList())
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.hide()
            } else {
                binding.movieProgressBar.hide()
                binding.movieRecyclerView.showErrorSnackbar(
                    "No Data Available",
                    Snackbar.LENGTH_LONG
                )
            }
        })
    }

}