package com.coronaapp.Activity.Bed_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.HospitalsKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityHospitalBinding
import com.coronaapp.model.Bed_Kosong.Hospitals.Hospital_Corona_BedKosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalBinding
    private lateinit var idProvince: String
    private lateinit var idCity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hospital)

        val intent = intent
        idProvince = intent.getStringExtra("idProvince").toString()
        idCity = intent.getStringExtra("idCity").toString()

        binding.btnBackHospitalsBedKosong.setOnClickListener {
            super.onBackPressed()
        }

        showDataHospitals()
    }

    private fun showDataHospitals() {
        binding.rvHospitalsBedKosong.setHasFixedSize(true)
        binding.progHospital.visibility = View.VISIBLE
        Retrofit_Bed_Kosong.instance.getHospitalsCovid(idProvince, idCity, "1").enqueue(object :
            Callback<Hospital_Corona_BedKosong> {

            override fun onResponse(
                call: Call<Hospital_Corona_BedKosong>,
                response: Response<Hospital_Corona_BedKosong>
            ) {
                val list = response.body()
                val hospitalAdapter = list?.let {
                    HospitalsKosongAdapter(it, this@HospitalActivity, HospitalDetailsActivity())
                }
                if (response.body()?.hospitals!!.size == 0) {
                    Toast.makeText(
                        this@HospitalActivity,
                        "Tidak ada RS tersedia",
                        Toast.LENGTH_LONG
                    ).show()
                }
                binding.progHospital.visibility = View.INVISIBLE
                binding.rvHospitalsBedKosong.adapter = hospitalAdapter

            }

            override fun onFailure(call: Call<Hospital_Corona_BedKosong>, t: Throwable) {
                Toast.makeText(this@HospitalActivity, t.message, Toast.LENGTH_SHORT).show()
                binding.progHospital.visibility = View.INVISIBLE
            }

        })
    }
}