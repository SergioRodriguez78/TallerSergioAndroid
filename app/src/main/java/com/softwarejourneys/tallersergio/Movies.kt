package com.softwarejourneys.tallersergio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.coroutines.NonDisposableHandle.parent

data class Movies (var ImagenUrl:String,var name:String,var duration:Int,var favorito:Boolean)

class MoviesAdapter( private val movies:List<Movies>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.template_movie,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int=  movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val movie= movies[position]

    }

}