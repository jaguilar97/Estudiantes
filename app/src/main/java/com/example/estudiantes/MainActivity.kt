package com.example.estudiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.estudiantes.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btnIngresar.setOnClickListener { ingresa() }
        binding.btnRegistrar.setOnClickListener { registrarse() }

    }

    private fun registrarse() {
        val email = binding.txtCorreo.text.toString()
        val clave = binding.txtContraseA.text.toString()

        auth.createUserWithEmailAndPassword(email,clave).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                actualiza(user)
            } else {
                Toast.makeText(baseContext,getString(R.string.msg_fallo_registro), Toast.LENGTH_SHORT).show()
                actualiza(null)
            }
        }

    }

    private fun ingresa() {
        TODO("Not yet implemented")
    }
}