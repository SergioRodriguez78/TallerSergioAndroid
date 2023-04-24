package com.softwarejourneys.tallersergio.ui.movies.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.softwarejourneys.tallersergio.R
import com.softwarejourneys.tallersergio.databinding.FragmentContainerMoviesBinding
import com.softwarejourneys.tallersergio.ui.movies.MoviesViewModel


class ContainerMoviesFragment : Fragment() {

    private lateinit var viewBinding: FragmentContainerMoviesBinding
    val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentContainerMoviesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = viewBinding.root

        moviesViewModel.initDatabase(requireContext())
        moviesViewModel.getAllMoviesFirstTime()


        //Iniciar movies second
        val moviesSecond = MoviesFragment()

        childFragmentManager.beginTransaction().add(viewBinding.fragmentContainer.id, moviesSecond)
            .commit()


        viewBinding.buttonFavorites.setOnClickListener {
            changeFragmentFavorite()
            viewBinding.buttonFavorites.setBackgroundColor(resources.getColor(R.color.purple_500))
            viewBinding.buttonMovies.setBackgroundColor(resources.getColor(R.color.purple_200))
        }
        viewBinding.buttonMovies.setOnClickListener {
            changeFragmentMovies()
            viewBinding.buttonMovies.setBackgroundColor(resources.getColor(R.color.purple_500))
            viewBinding.buttonFavorites.setBackgroundColor(resources.getColor(R.color.purple_200))
        }
        Log.i("pruebaS", "En el onCreateView del PELICULAS")
        return view
    }
    fun changeFragmentFavorite() {
        val moviesFavFragment = FavoritesMoviesFragment()

        val transaction = childFragmentManager.beginTransaction()

        transaction.replace(viewBinding.fragmentContainer.id, moviesFavFragment)
        transaction.commit()
    }

    fun changeFragmentMovies() {
        val moviesFragment = MoviesFragment()

        val transaction = childFragmentManager.beginTransaction()

        transaction.replace(viewBinding.fragmentContainer.id, moviesFragment)
        transaction.commit()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("pruebaS", "En el onAttach del PELICULAS")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("pruebaS", "En el onCreate del PELICULAS")
    }

    override fun onStart() {
        super.onStart()
        Log.i("pruebaS", "En el start del PELICULAS")
    }

    override fun onResume() {
        super.onResume()
        Log.i("pruebaS", "En el onresume del PELICULAS")
    }

    override fun onPause() {
        super.onPause()
        Log.i("pruebaS", "En el pause del PELICULAS")
    }

    override fun onStop() {
        super.onStop()
        Log.i("pruebaS", "En el stop del PELICULAS")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("pruebaS", "En el destroy del PELICULAS")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("pruebaS", "En el onDestroyView del PELICULAS")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("pruebaS", "En el onDetach del PELICULAS")
    }

}
