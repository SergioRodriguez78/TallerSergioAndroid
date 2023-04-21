package com.softwarejourneys.tallersergio.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.ui.adapter.MoviesAdapter

import com.softwarejourneys.tallersergio.databinding.FragmentFavoritesMoviesBinding


class FavoritesMoviesFragment : Fragment(), LogicFavoritesClick {

    private lateinit var viewBinding: FragmentFavoritesMoviesBinding
    val moviesViewModel: MoviesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentFavoritesMoviesBinding.inflate(layoutInflater)
        viewBinding.recyclerImagen.layoutManager = LinearLayoutManager(requireContext())

        moviesViewModel.getFavoriteMovies()

        moviesViewModel.movie.observe(viewLifecycleOwner/*Si fuera una actividad seria this*/) {

                it ->
            when (it) {
                is UiState.FavoriteMovies -> {
                    Log.i("prueba llegada en favoritos frag", it.movies.toString())

                    val adapter = MoviesAdapter(it.movies, this)
                    viewBinding.recyclerImagen.adapter = adapter
                }
                else -> {}
            }
        }

        return viewBinding.root
    }

    override fun onClickChangeFavorites(idMovie: Int, isChecked: Boolean) {
        moviesViewModel.changeStateFavorite(idMovie, isChecked, true)
    }


}