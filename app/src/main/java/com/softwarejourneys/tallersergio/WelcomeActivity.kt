package com.softwarejourneys.tallersergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softwarejourneys.tallersergio.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.welcomeButton.setOnClickListener {
            changeActivity(viewBinding.welcomeButton)
            Log.i("pruebaS","En el oncreate")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("pruebaS","En el start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("pruebaS","En el onresume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("pruebaS","En el pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("pruebaS","En el stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("pruebaS","En el destroy")
    }

    fun changeActivity(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}