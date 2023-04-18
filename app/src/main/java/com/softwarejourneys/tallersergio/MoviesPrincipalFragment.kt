package com.softwarejourneys.tallersergio

import android.os.Bundle
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

        val bottom= viewBinding.buttonFavorites.setOnClickListener{
            changeFragment()
        }



        return view
    }

    fun changeFragment(){
        val moviesFavFragment=FavoritesFragment()

        val transaction= childFragmentManager.beginTransaction()

        transaction.replace(viewBinding.fragmentContainer.id, moviesFavFragment)
        transaction.commit()
    }

}
