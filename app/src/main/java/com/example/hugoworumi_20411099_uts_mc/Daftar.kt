package com.example.hugoworumi_20411099_uts_mc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hugoworumi_20411099_uts_mc.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth

class Daftar : AppCompatActivity() {
    private lateinit var binding : ActivityDaftarBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this, Masuk::class.java)
            startActivity(intent)
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener{
            val email : String = binding.daftarEmail.text.toString().trim()
            val password : String = binding.daftarPassword.text.toString().trim()
            val confirm : String = binding.daftarConfirm.text.toString().trim()

            if(email.isEmpty()){
                binding.daftarEmail.error = "Input username"
                binding.daftarEmail.requestFocus()
                return@setOnClickListener

            } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.daftarEmail.error = "Email tidak valid"
                binding.daftarEmail.requestFocus()
                return@setOnClickListener

            } else if(password.isEmpty() || password.length < 8) {
                binding.daftarPassword.error = "Minimal 8 karakter dan Tidak boleh kosong"
                binding.daftarPassword.requestFocus()
                return@setOnClickListener

            } else if(password != confirm){
                binding.daftarPassword.error = "Password tidak Sama"
                binding.daftarPassword.requestFocus()
                return@setOnClickListener

            }else {
                registerUser(email, password)
            }

        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
                Intent(this, Masuk::class.java).also{
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            }else{
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}