package com.softwarejourneys.tallersergio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwarejourneys.tallersergio.databinding.ActivityMainBinding
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesFirstBinding


class MoviesPrincipalFragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentFMoviesFirstBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
         val view= viewBinding.root

        //Iniciar movies second
        val moviesSecond= Movies2Fragment()
        //Iniciar movies fav
        val moviesFav=FavoritesFragment()

        childFragmentManager.beginTransaction().add(viewBinding.peliculas.id, moviesSecond).commit()

        return  view
    }

}