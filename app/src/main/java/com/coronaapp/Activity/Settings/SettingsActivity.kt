package com.coronaapp.Activity.Settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.Activity.MainActivity
import com.coronaapp.R
import com.coronaapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackSettings.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.ShareAppsSectionn.setOnClickListener {

        }

        binding.LicenseSection.setOnClickListener {
            Intent(this, LicenseActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}