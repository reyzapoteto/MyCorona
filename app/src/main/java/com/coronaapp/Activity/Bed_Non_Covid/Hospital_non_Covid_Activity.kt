package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityHospitalNonCovidBinding

class Hospital_non_Covid_Activity : AppCompatActivity() {

    private lateinit var binding :ActivityHospitalNonCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalNonCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackHospitalsBedKosongNonCovid.setOnClickListener {
            super.onBackPressed()
        }
    }
}