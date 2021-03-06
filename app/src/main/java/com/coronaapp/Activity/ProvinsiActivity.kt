package com.coronaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.Province.ProvinsiAdapter
import com.coronaapp.api.Retrofit.RetrofitClient
import com.coronaapp.api.Retrofit.Retrofit_Provinsicovid
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
        binding.progProvince.visibility = View.VISIBLE


        Retrofit_Provinsicovid.instance.getProvinsi().enqueue(object : Callback<ProvinsiResponse> {

                override fun onResponse(
                    call: Call<ProvinsiResponse>,
                    response: Response<ProvinsiResponse>
                ) {
                    val list = response.body()
                    val provinceAdapter = list?.let { ProvinsiAdapter(it) }
                    binding.rvProvince.adapter = provinceAdapter
                    binding.progProvince.visibility = View.INVISIBLE
                }

                override fun onFailure(call: Call<ProvinsiResponse>, t: Throwable) {
                    Toast.makeText(this@ProvinsiActivity, t.message, Toast.LENGTH_SHORT).show()
                    Log.i("errorProvinsi", t.message.toString())
                    binding.progProvince.visibility = View.INVISIBLE

                }

            })
    }
}