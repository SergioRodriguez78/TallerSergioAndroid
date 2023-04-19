package com.softwarejourneys.tallersergio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonDisposableHandle.parent

data class Movies(var ImagenUrl: String, var name: String, var duration: Int, var favorito: Boolean)


class MoviesAdapter(private val movies: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageUrl = view.findViewById<ImageView>(R.id.imageView)
        val nameMovie = view.findViewById<TextView>(R.id.nameView)
        val durationMovie = view.findViewById<TextView>(R.id.durationView)
        val switchMovie = view.findViewById<CheckBox>(R.id.switchView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        Glide.with(holder.imageUrl.context).load(movie.ImagenUrl).override(500, 500).into(holder.imageUrl)

        holder.nameMovie.text = movie.name
        holder.durationMovie.text = movie.duration.toString()





    }

}