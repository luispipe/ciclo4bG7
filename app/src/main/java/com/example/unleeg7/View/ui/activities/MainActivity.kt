package com.example.unleeg7.View.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.unleeg7.R
import com.example.unleeg7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Asociar el activity con el layout
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Configuración para que funcione la animación
        binding.animationView.playAnimation()
        //Trancisión entre la animación y la siguiente activity (4s)
        handler= Handler(Looper.myLooper()!!)
        handler.postDelayed({
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }
}
