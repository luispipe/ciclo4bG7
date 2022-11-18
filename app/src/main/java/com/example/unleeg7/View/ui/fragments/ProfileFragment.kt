package com.example.unleeg7.View.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.unleeg7.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    val database:DatabaseReference= FirebaseDatabase.getInstance().getReference("User")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth= Firebase.auth
        val user= firebaseAuth.currentUser

        val name= view.findViewById<EditText>(R.id.nameProfile)
        val email= view.findViewById<EditText>(R.id.emailProfile)
        val birth= view.findViewById<EditText>(R.id.birthProfile)

        email.setText(user?.email.toString())

        //RealTime Database
        database.child(user?.uid.toString()).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                name.setText(snapshot.child("name").value.toString())
                birth.setText(snapshot.child("birthDate").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

      /*  database.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children){
                    if(ds.equals(user?.uid.toString())){
                        name.setText(ds.child("name").value.toString())
                        birth.setText(ds.child("birthDate").value.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })*/

    }


}