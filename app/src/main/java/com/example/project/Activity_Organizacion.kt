package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.ActivityOrganizacionBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var  binding: ActivityOrganizacionBinding
private lateinit var firebaseAuth: FirebaseAuth

class Activity_Organizacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityOrganizacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLog.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            val email = firebaseUser.email
        }
        else{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}