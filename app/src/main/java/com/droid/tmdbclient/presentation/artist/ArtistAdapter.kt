package com.droid.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.tmdbclient.data.model.artist.Artist
import com.droid.tmdbclient.databinding.ListItemBinding


class ArtistAdapter : ListAdapter<Artist, ArtistAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            with(binding) {
                titleTextView.text = artist.name
                Glide.with(imageView.context)
                    .load("https://image.tmdb.org/t/p/w500" + artist.profilePath)
                    .into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}

val diffUtil = object : DiffUtil.ItemCallback<Artist>() {
    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem == newItem
    }
}