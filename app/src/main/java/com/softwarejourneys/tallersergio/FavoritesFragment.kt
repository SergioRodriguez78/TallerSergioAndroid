package com.softwarejourneys.tallersergio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesFavBinding


class FavoritesFragment : Fragment() {

      private  lateinit var viewBinding: FragmentFMoviesFavBinding
      var movies= listOf<Movies>(Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","Batman",120,true),
          Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","spiderman",70,true),
          Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","joker",40,true),
          Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","señor de los anillos",240,true),
          Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","adsfa",80,true),
          Movies("https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg","mackbook",456,true)
      );

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding= FragmentFMoviesFavBinding.inflate(layoutInflater)

        val recycler= viewBinding.recyclerImagen
        recycler.layoutManager= LinearLayoutManager(activity)

        val adapter= MoviesAdapter(movies)
        recycler.adapter=adapter



return viewBinding.root
    }




}