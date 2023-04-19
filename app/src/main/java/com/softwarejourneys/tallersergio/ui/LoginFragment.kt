package com.softwarejourneys.tallersergio.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.softwarejourneys.tallersergio.R
import com.softwarejourneys.tallersergio.databinding.FragmentFLoginBinding


class LoginFragment : Fragment() {

    private lateinit var viewBindingLogin: FragmentFLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("pruebaS", "En el onAttach del fragmento login")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("pruebaS", "En el onCreate del fragmento login")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindingLogin = FragmentFLoginBinding.inflate(layoutInflater)
        val view = viewBindingLogin.root
        // Inflate the layout for this fragment

        val bottom = viewBindingLogin.buttonChange.setOnClickListener {
            changeFragment()
        }

        Log.i("pruebaS", "En el onCreateView del fragmento login")
        return view


    }

    fun changeFragment() {
        val moviesPrincipal = MoviesPrincipalFragment()

        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        transaction.replace(R.id.principal, moviesPrincipal)
        transaction.commit()


    }

    override fun onStart() {
        super.onStart()
        Log.i("pruebaS", "En el start del fragmento login")
    }

    override fun onResume() {
        super.onResume()
        Log.i("pruebaS", "En el onresume del fragmento login")
    }

    override fun onPause() {
        super.onPause()
        Log.i("pruebaS", "En el pause del fragmento login")
    }

    override fun onStop() {
        super.onStop()
        Log.i("pruebaS", "En el stop del fragmento login")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("pruebaS", "En el destroy del fragmento login")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("pruebaS", "En el onDestroyView del fragmento login")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("pruebaS", "En el onDetach del fragmento login")
    }


}