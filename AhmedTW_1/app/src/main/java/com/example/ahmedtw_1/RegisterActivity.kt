package com.example.ahmedtw_1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.databinding.ActivityRegisterBinding
import com.example.ahmedtw_1.ui.SecondActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoginRge.setOnClickListener {
            if (
                !binding.etUserRge.text.isNullOrEmpty() &&
                !binding.etPasswordRge.text.isNullOrEmpty()&&
                !binding.etPhoneRge.text.isNullOrEmpty()&&
                binding.etPasswordRge.text.toString() == binding.etCofirmRge.text.toString()
            ) {
                val intent=Intent(this,SecondActivity::class.java)
                intent.putExtra("name", binding.etUserRge.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "found error", Toast.LENGTH_LONG).show()
            }
        }
    }
}