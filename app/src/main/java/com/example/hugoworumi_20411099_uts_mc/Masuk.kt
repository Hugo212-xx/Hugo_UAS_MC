package com.example.hugoworumi_20411099_uts_mc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hugoworumi_20411099_uts_mc.databinding.ActivityMasukBinding
import com.google.firebase.auth.FirebaseAuth

class Masuk : AppCompatActivity() {

    private lateinit var binding : ActivityMasukBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

//      Tombol menuju halaman reset password
        binding.lupaPassword.setOnClickListener {
            val intent = Intent(this, LupaPassword::class.java)
            startActivity(intent)
        }

//      Tombol menuju halaman register
        binding.daftar.setOnClickListener {
            val intent = Intent(this, Daftar::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email : String = binding.loginEmail.text.toString().trim()
            val pass  : String = binding.loginPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.loginEmail.error = "Email Tidak Boleh Kosong"
                binding.loginEmail.requestFocus()
                return@setOnClickListener

            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.loginEmail.error = "Email Tidak Valid"
                binding.loginEmail.requestFocus()
                return@setOnClickListener

            }else if(pass.isEmpty() || pass.length < 8){
                binding.loginPassword.error = "Maksimal 8 karakter dan Tidak boleh kosong"
                binding.loginPassword.requestFocus()
                return@setOnClickListener

            }else{
                loginUser(email,pass)
            }

        }

    }
    private fun loginUser(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                Intent(this, Home::class.java).also{
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            }else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}