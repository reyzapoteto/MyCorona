package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityHospitalNonVocidDetailsBinding

class Hospital_Non_Vocid_Details_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalNonVocidDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalNonVocidDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackHospitalDetailsBedKosong.setOnClickListener {
            super.onBackPressed()
        }
    }
}