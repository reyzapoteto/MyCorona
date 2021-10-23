package com.coronaapp.Activity.Settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityLicenseBinding

class LicenseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLicenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLicenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackLicense.setOnClickListener {
            Intent(this,SettingsActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}