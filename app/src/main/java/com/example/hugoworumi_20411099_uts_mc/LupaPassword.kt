package com.example.hugoworumi_20411099_uts_mc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hugoworumi_20411099_uts_mc.databinding.ActivityLupaPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class LupaPassword : AppCompatActivity() {

    private lateinit var binding : ActivityLupaPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLupaPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.batal.setOnClickListener {
            val intent = Intent(this, Masuk::class.java)
            startActivity(intent)
        }

        binding.kirim.setOnClickListener {
            val email : String = binding.restEmail.text.toString().trim()

            if(email.isEmpty()){
                binding.restEmail.error = "Email Tidak Boleh Kosong"
                binding.restEmail.requestFocus()
                return@setOnClickListener

            } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.restEmail.error = "Email Tidak Valid"
                binding.restEmail.requestFocus()
                return@setOnClickListener

            } else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Cek email untuk Reset Password", Toast.LENGTH_SHORT).show()
                        Intent(this,Masuk::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }

                    }else{
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}