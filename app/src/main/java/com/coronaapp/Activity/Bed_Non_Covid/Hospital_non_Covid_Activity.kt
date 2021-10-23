package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coronaapp.adapter.BedKosong.HospitalsKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityHospitalNonCovidBinding
import com.coronaapp.model.Bed_Kosong.Hospitals.Hospital_Corona_BedKosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Hospital_non_Covid_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalNonCovidBinding
    private lateinit var idProvince: String
    private lateinit var idCity: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalNonCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        idProvince = intent.getStringExtra("idProvince").toString()
        idCity = intent.getStringExtra("idCity").toString()

        binding.btnBackHospitalsBedKosongNonCovid.setOnClickListener {
            super.onBackPressed()
        }

        showHospitalNonCovid()
    }

    private fun showHospitalNonCovid() {
        binding.rvHospitalsBedKosongNonCovid.setHasFixedSize(true)
        binding.progHospital.visibility = View.VISIBLE
        Retrofit_Bed_Kosong.instance.getHospitalsCovid(idProvince, idCity, "2").enqueue(object :
            Callback<Hospital_Corona_BedKosong> {

            override fun onResponse(
                call: Call<Hospital_Corona_BedKosong>,
                response: Response<Hospital_Corona_BedKosong>
            ) {
                val list = response.body()
                val hospitalAdapter = list?.let {
                    HospitalsKosongAdapter(
                        it,
                        this@Hospital_non_Covid_Activity,
                        Hospital_Non_Vocid_Details_Activity()
                    )
                }
                if (response.body()?.hospitals!!.size == 0) {
                    Toast.makeText(
                        this@Hospital_non_Covid_Activity,
                        "Tidak ada RS tersedia",
                        Toast.LENGTH_LONG
                    ).show()
                }
                binding.progHospital.visibility = View.INVISIBLE
                binding.rvHospitalsBedKosongNonCovid.adapter = hospitalAdapter

            }

            override fun onFailure(call: Call<Hospital_Corona_BedKosong>, t: Throwable) {
                Toast.makeText(this@Hospital_non_Covid_Activity, t.message, Toast.LENGTH_SHORT)
                    .show()
                binding.progHospital.visibility = View.INVISIBLE
            }

        })
    }
}