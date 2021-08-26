package com.droid.tmdbclient.presentation.movie


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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

    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
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