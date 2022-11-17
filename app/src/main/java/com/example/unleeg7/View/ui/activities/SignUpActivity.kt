package com.example.unleeg7.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unleeg7.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database

class SignUpActivity:AppCompatActivity() {
    lateinit var register: Button
    lateinit var firebaseAuth: FirebaseAuth

    lateinit var databaseReference: DatabaseReference
    //lateinit var database:FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        firebaseAuth= Firebase.auth
        //database= FirebaseDatabase.getInstance()
        databaseReference= Firebase.database.reference

        register= findViewById(R.id.register)
        val name= findViewById<EditText>(R.id.signupName)
        val email= findViewById<EditText>(R.id.signupEmail)
        val birth= findViewById<EditText>(R.id.signupBirthdate)
        val password= findViewById<EditText>(R.id.signupPassword)

        register.setOnClickListener {
            createUser(email.text.toString(),password.text.toString(), name.text.toString(),
                birth.text.toString()
                )
        }
    }

    fun createUser(email:String, password:String, name: String, birth:String){
       // firebaseAuth.currentUser?.sendEmailVerification()
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                Task->if (Task.isSuccessful){
                 val user=firebaseAuth.currentUser
                val userdb=databaseReference.child(user?.uid.toString())
                userdb.child("name").setValue(name)
                userdb.child("birthDate").setValue(birth)

                startActivity(Intent(this,LoginActivity::class.java))
            }else{
                Toast.makeText(applicationContext,"try again",Toast.LENGTH_LONG).show()
            }
            }
    }


}