package com.example.unleeg7.View.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unleeg7.R
import com.example.unleeg7.databinding.ActivityMainBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       // binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
    }
}