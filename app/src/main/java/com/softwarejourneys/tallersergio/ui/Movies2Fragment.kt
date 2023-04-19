package com.softwarejourneys.tallersergio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.model.Movies
import com.softwarejourneys.tallersergio.MoviesAdapter
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesSecondBinding
import com.softwarejourneys.tallersergio.viewModel.MoviesViewModel


class Movies2Fragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentFMoviesSecondBinding.inflate(layoutInflater)

        val recycler = viewBinding.recyclerImagen2
        recycler.layoutManager = LinearLayoutManager(activity)

        val adapter = MoviesAdapter(MoviesViewModel().getAllMovies())
        recycler.adapter = adapter




        return viewBinding.root
    }
}