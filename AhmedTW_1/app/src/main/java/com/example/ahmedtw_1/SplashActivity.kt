package com.example.ahmedtw_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    Handler().postDelayed({startActivity(Intent(this,MainActivity::class.java))
                                   finish()},3000)

    }
}