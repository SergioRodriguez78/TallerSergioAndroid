package com.softwarejourneys.tallersergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            Log.i("pruebaS","En el onCreate del main")
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("pruebaS","En el start del main")
    }

    override fun onResume() {
        super.onResume()
        Log.i("pruebaS","En el onresume del main")
    }

    override fun onPause() {
        super.onPause()
        Log.i("pruebaS","En el pause del main")
    }

    override fun onStop() {
        super.onStop()
        Log.i("pruebaS","En el stop del main")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("pruebaS","En el destroy del main")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("pruebaS","En el OnRestart del main")
    }
}