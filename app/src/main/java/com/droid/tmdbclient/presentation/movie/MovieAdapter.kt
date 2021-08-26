package com.droid.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.tmdbclient.R
import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val moviesList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.list_item, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size

    }
}


class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        with(binding) {
            titleTextView.text = movie.title
            descriptionTextView.text = movie.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
            Glide.with(imageView.context)
                .load(posterUrl)
                .into(imageView)
        }
    }

}