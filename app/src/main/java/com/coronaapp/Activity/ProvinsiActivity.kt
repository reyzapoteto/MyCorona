package com.coronaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.ProvinsiAdapter
import com.coronaapp.api.RetrofitClient
import com.coronaapp.databinding.ActivityProvinsiBinding
import com.coronaapp.model.Province.ProvinsiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProvinsiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_provinsi)
        showProvince()

        binding.btnBackProvince.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showProvince() {
        binding.rvProvince.setHasFixedSize(true)

        RetrofitClient.instance.getProvinsi()
            .enqueue(object : Callback<ArrayList<ProvinsiResponse>> {

                override fun onResponse(
                    call: Call<ArrayList<ProvinsiResponse>>,
                    response: Response<ArrayList<ProvinsiResponse>>
                ) {
                    val list = response.body()
                    val provinceAdapter = list?.let { ProvinsiAdapter(it) }
                    binding.rvProvince.adapter = provinceAdapter
                }

                override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                    Toast.makeText(this@ProvinsiActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}