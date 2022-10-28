package com.example.unleeg7.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unleeg7.R
import com.example.unleeg7.databinding.ActivityMainBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var signup: Button
    lateinit var home: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        signup= findViewById(R.id.signup)
        signup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        home= findViewById(R.id.login)
        home.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }
}