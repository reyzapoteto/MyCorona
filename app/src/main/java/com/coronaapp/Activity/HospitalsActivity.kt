package com.coronaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.Hospital.Hospitals_Adapter
import com.coronaapp.api.Retrofit.Retrofit_Rumah_Sakit
import com.coronaapp.databinding.ActivityHospitalsBinding
import com.coronaapp.model.RumahSakitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalsActivity : AppCompatActivity() {

    private lateinit var  binding:ActivityHospitalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hospitals)

        showHospitals()

        binding.btnBackHospitals.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showHospitals() {
        binding.rvHospitals.setHasFixedSize(true)
        binding.progHospital.visibility = View.VISIBLE
        Retrofit_Rumah_Sakit.instance.getHospital().enqueue(object :Callback<ArrayList<RumahSakitResponse>>{
            override fun onResponse(
                call: Call<ArrayList<RumahSakitResponse>>,
                response: Response<ArrayList<RumahSakitResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { Hospitals_Adapter(it) }
                binding.rvHospitals.adapter = adapter
                binding.progHospital.visibility = View.INVISIBLE

            }

            override fun onFailure(call: Call<ArrayList<RumahSakitResponse>>, t: Throwable) {
                            Toast.makeText(this@HospitalsActivity,t.message,Toast.LENGTH_SHORT).show()
                            Log.i("ErrorHospital",t.message.toString())
                binding.progHospital.visibility = View.INVISIBLE
            }

        })
    }
}