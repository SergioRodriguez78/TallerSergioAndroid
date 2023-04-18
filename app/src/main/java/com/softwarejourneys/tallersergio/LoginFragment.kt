package com.softwarejourneys.tallersergio

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.softwarejourneys.tallersergio.databinding.ActivityMainBinding
import com.softwarejourneys.tallersergio.databinding.FragmentFLoginBinding


class LoginFragment : Fragment() {

    private lateinit var viewBindingLogin: FragmentFLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindingLogin= FragmentFLoginBinding.inflate(layoutInflater)
        val view= viewBindingLogin.root
        // Inflate the layout for this fragment

        val bottom= viewBindingLogin.buttonChange.setOnClickListener{
            changeFragment()
        }

        return view
    }

    fun changeFragment(){
        val moviesPrincipal= MoviesPrincipalFragment()

        val transaction= requireActivity().supportFragmentManager.beginTransaction()

        transaction.replace(R.id.principal,moviesPrincipal)
        transaction.commit()



    }


}