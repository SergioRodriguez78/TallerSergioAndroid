package com.softwarejourneys.tallersergio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwarejourneys.tallersergio.databinding.FragmentFMoviesSecondBinding

class Movies2Fragment : Fragment() {

    private lateinit var viewBinding: FragmentFMoviesSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentFMoviesSecondBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}