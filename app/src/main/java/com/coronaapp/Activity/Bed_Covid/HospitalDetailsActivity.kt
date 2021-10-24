package com.coronaapp.Activity.Bed_Covid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.HospitalDetailsKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityHospitalDetailsBinding
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong
import com.coronaapp.model.Bed_Kosong.Hospital_Maps.Hospital_Data_Maps
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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

        binding.btnImgMaps.setOnClickListener {
            showHospitalMaps()
        }


        showDataBedKosong()

    }

    private fun showHospitalMaps() {
        Retrofit_Bed_Kosong.instance.getHospitalsDetailMaps(idHospitals).enqueue(object :Callback<Hospital_Data_Maps>{

            override fun onResponse(
                call: Call<Hospital_Data_Maps>,
                response: Response<Hospital_Data_Maps>
            ) {
                val responseResult = response.body()?.data
                val gmaps = responseResult?.gmaps

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gmaps))
                startActivity(intent)

            }

            override fun onFailure(call: Call<Hospital_Data_Maps>, t: Throwable) {
                Toast.makeText(this@HospitalDetailsActivity,t.message,Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showDataBedKosong() {
        binding.progHospital.visibility = View.VISIBLE
        Retrofit_Bed_Kosong.instance.getHospitalsDetail(idHospitals, "1").enqueue(object :
            Callback<Hospital_Details_BedKosong> {

            override fun onResponse(
                call: Call<Hospital_Details_BedKosong>,
                response: Response<Hospital_Details_BedKosong>
            ) {

                val responsenya = response.body()?.data
                val name = responsenya?.name
                val address = responsenya?.address
                val phone = responsenya?.phone

                binding.tvTitleHospitalDetails.text = name
                binding.tvHospitalAddress.text = address
                binding.tvPhoneHospital.text = phone

                val list = response.body()
                val hospitalsDetailAdapter =
                    list?.let { HospitalDetailsKosongAdapter(this@HospitalDetailsActivity, it) }
                binding.rvHospitalsDetailsBedKosong.adapter = hospitalsDetailAdapter
                binding.progHospital.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<Hospital_Details_BedKosong>, t: Throwable) {
                Toast.makeText(this@HospitalDetailsActivity, t.message, Toast.LENGTH_SHORT).show()
                binding.progHospital.visibility = View.INVISIBLE
            }

        })
    }
}