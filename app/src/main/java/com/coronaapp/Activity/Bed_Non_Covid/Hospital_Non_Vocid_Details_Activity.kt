package com.coronaapp.Activity.Bed_Non_Covid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coronaapp.adapter.BedKosong.HospitalDetailsKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityHospitalNonVocidDetailsBinding
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong
import com.coronaapp.model.Bed_Kosong.Hospital_Maps.Hospital_Data_Maps
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Hospital_Non_Vocid_Details_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalNonVocidDetailsBinding
    private lateinit var idHospitals: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalNonVocidDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        idHospitals = intent.getStringExtra("idHospital").toString()

        binding.btnBackHospitalDetailsBedKosong.setOnClickListener {
            super.onBackPressed()
        }

        binding.btnImgMaps.setOnClickListener {
            showMaps()
        }
        showDetailbedKosongNonCovid()
    }

    private fun showMaps() {
        Retrofit_Bed_Kosong.instance.getHospitalsDetailMaps(idHospitals)
            .enqueue(object : Callback<Hospital_Data_Maps> {
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
                    Toast.makeText(
                        this@Hospital_Non_Vocid_Details_Activity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }

    private fun showDetailbedKosongNonCovid() {
        binding.progHospital.visibility = View.VISIBLE
        binding.rvHospitalsDetailsBedKosong.setHasFixedSize(true)
        Retrofit_Bed_Kosong.instance.getHospitalsDetail(idHospitals, "2")
            .enqueue(object : Callback<Hospital_Details_BedKosong> {

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
                        list?.let {
                            HospitalDetailsKosongAdapter(
                                this@Hospital_Non_Vocid_Details_Activity,
                                it
                            )
                        }

                    binding.rvHospitalsDetailsBedKosong.adapter = hospitalsDetailAdapter
                    binding.progHospital.visibility = View.INVISIBLE
                }

                override fun onFailure(call: Call<Hospital_Details_BedKosong>, t: Throwable) {
                    Toast.makeText(
                        this@Hospital_Non_Vocid_Details_Activity,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                    binding.progHospital.visibility = View.INVISIBLE
                }

            })
    }


}