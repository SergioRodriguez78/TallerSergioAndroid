package com.softwarejourneys.tallersergio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.model.Movies
import com.softwarejourneys.tallersergio.MoviesAdapter
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesFavBinding
import com.softwarejourneys.tallersergio.viewModel.MoviesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FavoritesFragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesFavBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentFMoviesFavBinding.inflate(layoutInflater)

        val recycler = viewBinding.recyclerImagen
        recycler.layoutManager = LinearLayoutManager(activity)



        requireActivity().runOnUiThread(MoviesViewModel().getAllMovies())

        val adapter = MoviesAdapter()
        recycler.adapter = adapter



        return viewBinding.root
    }


}