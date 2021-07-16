package com.coronaapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.databinding.ActivityProningBinding

class ProningActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proning)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_proning)

        binding.btnBackProning.setOnClickListener {
            super.onBackPressed()
        }

    }
}