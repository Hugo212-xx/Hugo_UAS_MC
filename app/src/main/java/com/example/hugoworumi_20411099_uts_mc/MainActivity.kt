package com.example.hugoworumi_20411099_uts_mc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_login.setOnClickListener {
            Intent(this, hlm_content::class.java).also {
                startActivity(it)
            }
        }

        val btn_register = findViewById<Button>(R.id.btn_register)

        btn_register.setOnClickListener {
            Intent(this, hlm_register::class.java).also {
                startActivity(it)
            }
        }
    }
}