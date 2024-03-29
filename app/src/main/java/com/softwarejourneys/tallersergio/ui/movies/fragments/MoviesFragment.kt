package com.softwarejourneys.tallersergio.ui.movies.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.ui.movies.adapter.MoviesAdapter

import com.softwarejourneys.tallersergio.databinding.FragmentMoviesBinding
import com.softwarejourneys.tallersergio.ui.movies.LogicFavoritesClick
import com.softwarejourneys.tallersergio.ui.movies.MoviesViewModel
import com.softwarejourneys.tallersergio.ui.movies.UiState


class MoviesFragment : Fragment(), LogicFavoritesClick {

    private lateinit var viewBinding: FragmentMoviesBinding
    val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentMoviesBinding.inflate(layoutInflater)
        viewBinding.recyclerImagen2.layoutManager = LinearLayoutManager(requireContext())

        moviesViewModel.getMovies()
        moviesViewModel.movie.observe(viewLifecycleOwner/*Si fuera una actividad seria this*/) {

                it ->
            when (it) {

                is UiState.ListMovies -> {
                    Log.i("prueba lllegada en el fragmento", it.movies.toString())

                    val adapter = MoviesAdapter(it.movies, this)
                    viewBinding.recyclerImagen2.adapter = adapter
                }
                else -> {}
            }
        }



        return viewBinding.root
    }

    override fun onClickChangeFavorites(idMovie: Int, isChecked: Boolean) {
        moviesViewModel.changeStateFavorite(idMovie, isChecked,false)
    }
}