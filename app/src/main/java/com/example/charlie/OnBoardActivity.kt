package com.example.charlie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.charlie.databinding.ActivityOnboardBinding
import com.example.charlie.ui.audiens.AudiensActivity
import com.example.charlie.ui.authentication.LoginActivity
import com.example.charlie.ui.authentication.RegisterActivity
import com.example.charlie.ui.kreator.KreatorActivity

class OnBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clAudiens.setOnClickListener {
            val intent = Intent(this, AudiensActivity::class.java)
            startActivity(intent)
        }

        binding.clKreator.setOnClickListener {
            val intent = Intent(this, KreatorActivity::class.java)
            startActivity(intent)
        }
    }
}