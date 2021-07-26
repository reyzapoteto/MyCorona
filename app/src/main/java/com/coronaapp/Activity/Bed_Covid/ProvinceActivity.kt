package com.coronaapp.Activity.Bed_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.BedKosong.ProvinceBedKosongAdapter
import com.coronaapp.api.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityProvinceBinding
import com.coronaapp.model.Bed_Kosong.All_Provinces.Corona_Bed_Kosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProvinceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_province)

        binding.btnBackProvinceBedKosong.setOnClickListener {
            super.onBackPressed()
        }

        showProvinceBedKosong()
    }

    private fun showProvinceBedKosong() {
        binding.rvProvinceBedKosong.setHasFixedSize(true)

        Retrofit_Bed_Kosong.instance.getAllProvinces().enqueue(object :Callback<Corona_Bed_Kosong>{

            override fun onResponse(
                call: Call<Corona_Bed_Kosong>,
                response: Response<Corona_Bed_Kosong>
            ) {
                val list =response.body()
                val provinceAdapter =list?.let {ProvinceBedKosongAdapter(it,this@ProvinceActivity   ) }
                binding.rvProvinceBedKosong.adapter = provinceAdapter            }

            override fun onFailure(call: Call<Corona_Bed_Kosong>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}