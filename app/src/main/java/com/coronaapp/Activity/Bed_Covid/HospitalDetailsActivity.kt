package com.coronaapp.Activity.Bed_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.HospitalDetailsKosongAdapter
import com.coronaapp.api.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityHospitalDetailsBinding
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalDetailsBinding
    private lateinit var idHospitals: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hospital_details)

        val intent = intent
        idHospitals = intent.getStringExtra("idHospital").toString()

        binding.btnBackHospitalDetailsBedKosong.setOnClickListener {
            super.onBackPressed()
        }
        showDataBedKosong()

    }

    private fun showDataBedKosong() {
        Retrofit_Bed_Kosong.instance.getHospitalsDetail(idHospitals, "1").enqueue(object :
            Callback<Hospital_Details_BedKosong> {

            override fun onResponse(
                call: Call<Hospital_Details_BedKosong>,
                response: Response<Hospital_Details_BedKosong>
            ) {

                val responsenya = response.body()?.data
                val name = responsenya?.name
                val id = responsenya?.id
                val address = responsenya?.address
                val phone = responsenya?.phone

                binding.tvTitleHospitalDetails.text = name
                binding.tvHospitalAddress.text = address
                binding.tvPhoneHospital.text = phone

                val list = response.body()
                val hospitalsDetailAdapter =
                    list?.let { HospitalDetailsKosongAdapter(this@HospitalDetailsActivity, it) }
                binding.rvHospitalsDetailsBedKosong.adapter = hospitalsDetailAdapter

            }

            override fun onFailure(call: Call<Hospital_Details_BedKosong>, t: Throwable) {
                Toast.makeText(this@HospitalDetailsActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}