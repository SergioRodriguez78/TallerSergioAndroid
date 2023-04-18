package com.softwarejourneys.tallersergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.softwarejourneys.tallersergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if (savedInstanceState == null) {
            //iniciar fragmento de login

            val loginFragment = LoginFragment()

            //inicia fragmento de movies primero
            val MFirstFragment = MoviesPrincipalFragment()

            //añadir fragmentos al manager
            supportFragmentManager.beginTransaction().add(viewBinding.principal.id, loginFragment)
                .commit()
        }
    }
}