package com.softwarejourneys.tallersergio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesFavBinding


class FavoritesFragment : Fragment() {

      private  lateinit var viewBinding: FragmentFMoviesFavBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding= FragmentFMoviesFavBinding.inflate(layoutInflater)

        val recycler= viewBinding.recyclerImagen
        recycler.adapter=


return viewBinding.root    }


}