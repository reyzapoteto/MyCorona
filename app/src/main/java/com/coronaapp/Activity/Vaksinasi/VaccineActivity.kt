package com.coronaapp.Activity.Vaksinasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.Activity.MainActivity
import com.coronaapp.R
import com.coronaapp.api.Retrofit.Retrofit_Vaccine
import com.coronaapp.databinding.ActivityVaccineBinding
import com.coronaapp.model.Vaccine.VaccineResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VaccineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVaccineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vaccine)

        binding.btnBackVaccine.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnJenisVaksin.setOnClickListener {
            Intent(this, JenisVaksinasi::class.java).also {
                startActivity(it)
            }
        }
        showVaccine()
    }

    private fun showVaccine() {

        Retrofit_Vaccine.instance.getVaccine().enqueue(object : Callback<VaccineResponse> {
            override fun onFailure(call: Call<VaccineResponse>, t: Throwable) {
                Toast.makeText(this@VaccineActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<VaccineResponse>,
                response: Response<VaccineResponse>
            ) {

                val totalVaccineResponse = response.body()?.totalSasaran
                val totalVaccineSDMKResponse = response.body()?.sasaranSdmk
                val totalVaccinePublicResponse = response.body()?.sasaranPetugasPublik
                val totalVaccineElderyResponse = response.body()?.sasaranLansia
                val tanggalVaccineResponse = response.body()?.lastUpdate

                binding.tvTotalVaccine.text = totalVaccineResponse.toString()
                binding.tvVaccinePublic.text = totalVaccinePublicResponse.toString()
                binding.tvVaccineSDMK.text = totalVaccineSDMKResponse.toString()
                binding.tvVaccineEldery.text = totalVaccineElderyResponse.toString()
                binding.tvUpdateVaccine.text = tanggalVaccineResponse.toString()

            }

        })
    }
}