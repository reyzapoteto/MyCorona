package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityCityNonCoronaBinding

class City_non_corona_Activity : AppCompatActivity() {

    private lateinit var bindig : ActivityCityNonCoronaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityCityNonCoronaBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        bindig.btnBackCityBedKosongNonCovid.setOnClickListener {
            super.onBackPressed()
        }
    }
}