package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.ProvinceBedKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityProvinceNonCovidBinding
import com.coronaapp.model.Bed_Kosong.All_Provinces.Corona_Bed_Kosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        showProvinceNonCoronaBedKosong()
    }

    private fun showProvinceNonCoronaBedKosong() {
        binding.rvProvinceBedKosongNonCovid.setHasFixedSize(true)
        binding.progProvince.visibility = View.VISIBLE
        Retrofit_Bed_Kosong.instance.getAllProvinces().enqueue(object :
            Callback<Corona_Bed_Kosong> {

            override fun onResponse(
                call: Call<Corona_Bed_Kosong>,
                response: Response<Corona_Bed_Kosong>
            ) {
                val list = response.body()
                val provinceAdapter = list?.let {
                    ProvinceBedKosongAdapter(
                        it, this@Province_non_covid_activity,
                        City_non_corona_Activity()
                    )
                }
                binding.rvProvinceBedKosongNonCovid.adapter = provinceAdapter
                binding.progProvince.visibility = View.INVISIBLE

            }

            override fun onFailure(call: Call<Corona_Bed_Kosong>, t: Throwable) {
                Toast.makeText(this@Province_non_covid_activity, t.message, Toast.LENGTH_SHORT)
                    .show()
                binding.progProvince.visibility = View.INVISIBLE
            }
        })
    }
}