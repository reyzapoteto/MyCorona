package com.coronaapp.Activity.Bed_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.CityBedKosongAdapter
import com.coronaapp.api.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityCityBinding
import com.coronaapp.model.Bed_Kosong.Cities.City_Corona_BedKosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityActivity : AppCompatActivity() {

    private  lateinit var binding :ActivityCityBinding
    private lateinit var idProvince: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_city)

        val intent = intent
        idProvince = intent.getStringExtra("idProvince")!!

        binding.btnBackCityBedKosong.setOnClickListener {
            super.onBackPressed()
        }

        showCityBedKosong()
    }

    private fun showCityBedKosong() {
        binding.rvCityBedKosong.setHasFixedSize(true)

        Retrofit_Bed_Kosong.instance.getCities(idProvince).enqueue(object :Callback<City_Corona_BedKosong>{

            override fun onResponse(
                call: Call<City_Corona_BedKosong>,
                response: Response<City_Corona_BedKosong>
            ) {
                val list = response.body()
                val cityAdapter = list?.let { CityBedKosongAdapter(it,this@CityActivity,idProvince) }
                binding.rvCityBedKosong.adapter =cityAdapter
            }


            override fun onFailure(call: Call<City_Corona_BedKosong>, t: Throwable) {
                Toast.makeText(this@CityActivity,t.message,Toast.LENGTH_SHORT).show()
            }

        })
    }
}