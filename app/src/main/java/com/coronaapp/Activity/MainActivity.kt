package com.coronaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coronaapp.R
import com.coronaapp.adapter.GlobalAdapter
import com.coronaapp.api.RetrofitClient
import com.coronaapp.api.RetrofitClient_Day
import com.coronaapp.databinding.ActivityMainBinding
import com.coronaapp.model.Indonesia.IndonesiaResponse
import com.coronaapp.model.UpdateCorona
import com.coronaapp.model.globalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        showIndonesia()
        showGlobal()
        showIndonesiaDaily()

        binding.cardCoronaProvince.setOnClickListener {
            val intent = Intent(this, ProvinsiActivity::class.java)
            startActivity(intent)
        }

        binding.cardCoronaProning.setOnClickListener {
            Intent(this,ProningActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.cardHospitals.setOnClickListener {
            Intent(this, HospitalsActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.cardVaccine.setOnClickListener {
            Intent(this, VaccineActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun showGlobal() {

        binding.rvGlobal.setHasFixedSize(true)

        RetrofitClient.instance.getGlobal().enqueue(object : Callback<ArrayList<globalResponse>> {
            override fun onResponse(
                call: Call<ArrayList<globalResponse>>,
                response: Response<ArrayList<globalResponse>>
            ) {
                val list = response.body()
                val globalAdapter = list?.let { GlobalAdapter(it) }
                binding.rvGlobal.adapter = globalAdapter
            }

            override fun onFailure(call: Call<ArrayList<globalResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.i("ErrorGlobal", t.message.toString())
            }


        })
    }

    private fun showIndonesiaDaily(){
      RetrofitClient_Day.instance.getDailyAdd().enqueue(object :Callback<UpdateCorona>{
          override fun onResponse(call: Call<UpdateCorona>, response: Response<UpdateCorona>) {
              val responsenya = response.body()?.penambahan

              binding.tvCasesRecoveredDaily.text = responsenya?.RecoveredCases.toString()
              binding.tvCasesDeathDaily.text = responsenya?.DeathCases.toString()
              binding.tvCasesPositiveDaily.text = responsenya?.positiveCases.toString()
              binding.tvCasesTreatDaily.text = responsenya?.TreatCases.toString()
              binding.tvDateCaseDaily.text = responsenya?.tanggal.toString()

          }

          override fun onFailure(call: Call<UpdateCorona>, t: Throwable) {
              Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_SHORT).show()
          }

      })

    }
    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>> {

            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {

                // we catch the body of Api
                val indonesiaResponse = response.body()?.get(0)
                val casePositive = indonesiaResponse?.positif
                val caseNegatif = indonesiaResponse?.sembuh
                val caseHospitalize = indonesiaResponse?.dirawat
                val caseDeath = indonesiaResponse?.meninggal
                val caseCountry = indonesiaResponse?.name

                binding.tvDescDeath.text = caseDeath
                binding.tvDescInfected.text = casePositive
                binding.tvDescHospitallize.text = caseHospitalize
                binding.tvDescRecovered.text = caseNegatif
                binding.tvCountryName.text = caseCountry
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }


}