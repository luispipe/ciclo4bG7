package com.example.unleeg7.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unleeg7.R

class SignUpActivity:AppCompatActivity() {
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        register= findViewById(R.id.register)
        register.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}