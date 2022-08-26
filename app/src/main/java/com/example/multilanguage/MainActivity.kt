package com.example.multilanguage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multilanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("Data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.btnEnglish.setOnClickListener {
            editor.putString("locale", "en")
            editor.apply()
            startActivity(Intent(this, LanguageActivity::class.java))
        }

        binding.btnVietnamese.setOnClickListener {
            editor.apply()
            startActivity(Intent(this, LanguageActivity::class.java))
        }
    }
}