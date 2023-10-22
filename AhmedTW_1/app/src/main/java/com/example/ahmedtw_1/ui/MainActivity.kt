package com.example.ahmedtw_1.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.RegisterActivity
import com.example.ahmedtw_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("name",binding.etUser.text.toString())
            startActivity(intent)
        }
        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }
    }
}