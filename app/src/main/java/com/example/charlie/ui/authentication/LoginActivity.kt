package com.example.charlie.ui.authentication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.charlie.databinding.ActivityLoginBinding
import com.example.charlie.ui.rate_card_schedule.RateCardScheduleActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, RateCardScheduleActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}