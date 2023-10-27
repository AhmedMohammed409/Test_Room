package com.example.ahmedtw_1.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.R
import com.example.ahmedtw_1.databinding.ActivityLoginBinding
import com.example.ahmedtw_1.ui.list.ListActivity
import com.example.ahmedtw_1.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val name = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateForm(name, password)) {
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.found_an_error), Toast.LENGTH_LONG).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    private fun validateForm(name: String, password: String): Boolean {
        if (name.isEmpty() || name.length < 3) return false
        if (password.isEmpty() || password.length < 6) return false

        return true
    }
}