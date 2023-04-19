package com.softwarejourneys.tallersergio

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.softwarejourneys.tallersergio.databinding.ActivityMainBinding
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesFirstBinding

private const val NUM_PAGES = 2
class MoviesPrincipalFragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesFirstBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("pruebaS","En el onAttach del PELICULAS")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("pruebaS","En el onCreate del PELICULAS")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFMoviesFirstBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = viewBinding.root


        //Iniciar movies second
        val moviesSecond = Movies2Fragment()
        //Iniciar movies fav
        val moviesFav = FavoritesFragment()

        childFragmentManager.beginTransaction().add(viewBinding.fragmentContainer.id, moviesSecond).commit()

        val bottomFavorite= viewBinding.buttonFavorites.setOnClickListener{
            changeFragmentFavorite()
        }

        val bottomMovies= viewBinding.buttonMovies.setOnClickListener{
            changeFragmentMovies()
        }


        Log.i("pruebaS","En el onCreateView del PELICULAS")
        return view
    }

    fun changeFragmentFavorite(){
        val moviesFavFragment=FavoritesFragment()

        val transaction= childFragmentManager.beginTransaction()

        transaction.replace(viewBinding.fragmentContainer.id, moviesFavFragment)
        transaction.commit()
    }
    fun changeFragmentMovies(){
        val moviesFragment= Movies2Fragment()

        val transaction= childFragmentManager.beginTransaction()

        transaction.replace(viewBinding.fragmentContainer.id, moviesFragment)
        transaction.commit()
    }
    override fun onStart() {
        super.onStart()
        Log.i("pruebaS","En el start del PELICULAS")
    }

    override fun onResume() {
        super.onResume()
        Log.i("pruebaS","En el onresume del PELICULAS")
    }

    override fun onPause() {
        super.onPause()
        Log.i("pruebaS","En el pause del PELICULAS")
    }

    override fun onStop() {
        super.onStop()
        Log.i("pruebaS","En el stop del PELICULAS")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("pruebaS","En el destroy del PELICULAS")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("pruebaS","En el onDestroyView del PELICULAS")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("pruebaS","En el onDetach del PELICULAS")
    }

}
