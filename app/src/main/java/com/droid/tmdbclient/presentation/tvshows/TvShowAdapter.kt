package com.droid.tmdbclient.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.tmdbclient.data.model.tvshow.TvShow
import com.droid.tmdbclient.databinding.ListItemBinding

class TvShowAdapter : ListAdapter<TvShow, TvShowAdapter.ViewHolder>(
    diffUtil
) {
    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                titleTextView.text = tvShow.name
                descriptionTextView.text = tvShow.overview
                val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
                Glide.with(imageView.context)
                    .load(posterUrl)
                    .into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

val diffUtil = object : DiffUtil.ItemCallback<TvShow>() {
    override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem.id == newItem.id
    }
}


