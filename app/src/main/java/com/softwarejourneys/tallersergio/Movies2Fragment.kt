package com.softwarejourneys.tallersergio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesSecondBinding

var movies= listOf<Movies>(Movies("https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png","goku",120,false),
    Movies("https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png","adsf",70,false),
    Movies("https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png","joker",40,false),

);
class Movies2Fragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentFMoviesSecondBinding.inflate(layoutInflater)

        val recycler= viewBinding.recyclerImagen2
        recycler.layoutManager= LinearLayoutManager(activity)

        val adapter= MoviesAdapter(movies)
        recycler.adapter=adapter




        return viewBinding.root
    }
}