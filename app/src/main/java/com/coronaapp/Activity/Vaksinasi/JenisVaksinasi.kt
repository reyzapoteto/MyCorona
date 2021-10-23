package com.coronaapp.Activity.Vaksinasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityJenisVaksinasiBinding

class JenisVaksinasi : AppCompatActivity() {

    private lateinit var binding: ActivityJenisVaksinasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisVaksinasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackJenisVaksin.setOnClickListener {
            Intent(this, VaccineActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}