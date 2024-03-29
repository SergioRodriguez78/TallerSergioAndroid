package com.softwarejourneys.tallersergio.ui.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softwarejourneys.tallersergio.R
import com.softwarejourneys.tallersergio.ui.movies.model.Movie
import com.softwarejourneys.tallersergio.ui.movies.LogicFavoritesClick


class MoviesAdapter(private val movies: List<Movie>?, private val listener: LogicFavoritesClick) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {




    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageUrl: ImageView = view.findViewById<ImageView>(R.id.imageView)
        val nameMovie: TextView = view.findViewById<TextView>(R.id.nameView)
        val durationMovie: TextView = view.findViewById<TextView>(R.id.durationView)
        val checkBox: CheckBox = view.findViewById<CheckBox>(R.id.switchView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies?.get(position)

        Glide.with(holder.imageUrl.context).load(movie?.ImageUrl).override(500, 500)
            .into(holder.imageUrl)

        holder.nameMovie.text = movie?.name
        holder.durationMovie.text = movie?.duration.toString()

        holder.checkBox.isChecked = movie?.favorite!!

        holder.checkBox.setOnClickListener {
            listener.onClickChangeFavorites(movie.id, !movie.favorite)
        }


    }

}