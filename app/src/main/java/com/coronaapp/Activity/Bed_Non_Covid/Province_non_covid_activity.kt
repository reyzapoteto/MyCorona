package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityProvinceNonCovidBinding

class Province_non_covid_activity : AppCompatActivity() {

    private lateinit var binding: ActivityProvinceNonCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province_non_covid)
        binding = ActivityProvinceNonCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackProvinceBedKosongNonCovid.setOnClickListener {
            super.onBackPressed()
        }
    }
}