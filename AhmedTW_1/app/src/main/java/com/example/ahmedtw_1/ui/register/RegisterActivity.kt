package com.example.ahmedtw_1.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.R
import com.example.ahmedtw_1.databinding.ActivityRegisterBinding
import com.example.ahmedtw_1.ui.list.ListActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etUsername.text.toString()
            val phone = binding.etPhone.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            if (validateForm(name, phone, password, confirmPassword)) {
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.found_an_error), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(
        name: String,
        phone: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (name.isEmpty() || name.length < 3) return false
        if (phone.isEmpty() || phone.length < 11) return false
        if (password.isEmpty() || password.length < 6) return false
        if (confirmPassword.isEmpty() || confirmPassword.length < 6 || confirmPassword != password) return false

        return true
    }
}