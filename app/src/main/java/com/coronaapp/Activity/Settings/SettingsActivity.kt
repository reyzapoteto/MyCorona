package com.coronaapp.Activity.Settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.Activity.MainActivity
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
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val body =" ayo gunakan aplikasi kita sehat untuk tracking data terkini mengenai Covid 19 yang terjadi di indonsia"
            val title = "Ayo gunakan Kita Sehat"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,title)
            shareIntent.putExtra(Intent.EXTRA_TEXT,body)
            startActivity(Intent.createChooser(shareIntent,"Share Using"))
        }

        binding.LicenseSection.setOnClickListener {
            Intent(this, LicenseActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}