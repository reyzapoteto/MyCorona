package com.coronaapp.Activity

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.coronaapp.Activity.Bed_Covid.ProvinceActivity
import com.coronaapp.Activity.Bed_Non_Covid.Province_non_covid_activity
import com.coronaapp.Activity.Settings.SettingsActivity
import com.coronaapp.Activity.Vaksinasi.VaccineActivity
import com.coronaapp.R
import com.coronaapp.adapter.Global.GlobalAdapter
import com.coronaapp.api.Retrofit.RetrofitClient
import com.coronaapp.api.Retrofit.RetrofitClient_Day
import com.coronaapp.databinding.ActivityMainBinding
import com.coronaapp.model.Indonesia.IndonesiaResponse
import com.coronaapp.model.UpdateCorona
import com.coronaapp.model.globalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.DialogInterface
import android.provider.SyncStateContract
import android.service.controls.ControlsProviderService.TAG
import androidx.constraintlayout.widget.StateSet.TAG
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    companion object {

        private const val STATE_RESULT_INFECTED = "state_result"
        private const val STATE_RESULT_DEATH = "state_result_death"
        private const val STATE_RESULT_RECOVERED = "state_result_recovered"
        private const val STATE_RESULT_TREATED = "state_result_treated"

    }

    private var valueIndonesia: Boolean = false
    private var valueGlobal: Boolean = false
    private var valueDaily: Boolean = false

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        showIndonesia()
        showGlobal()
        showIndonesiaDaily()

        if (isOnline()) {
            // user already connect to internet
        }else{
            try {
                AlertDialog
                    .Builder(this@MainActivity)
                    .setTitle("Hah, kok Mati ?")
                    .setMessage("Sepertinya anda belum terkoneksi dengan internet , silahkan coba lagi")
                    .setCancelable(false)
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setNeutralButton("Oke"
                    ) { _, _ -> finish() }
                    .show()
            } catch (e: Exception) {

                Log.d("user", "Show Dialog: " + e.message)

            }
        }

        binding.cardCoronaBedKosong.setOnClickListener {
            Intent(this, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.imgButtonSettings.setOnClickListener {
            Intent(this, SettingsActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.cardNonCoronaBedKosong.setOnClickListener {
            Intent(this, Province_non_covid_activity::class.java).also {
                startActivity(it)
            }
        }

        binding.cardCoronaProvince.setOnClickListener {
            val intent = Intent(this, ProvinsiActivity::class.java)
            startActivity(intent)
        }

        binding.cardCoronaProning.setOnClickListener {
            Intent(this, ProningActivity::class.java).also {
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

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT_INFECTED)
            val resultRecovered = savedInstanceState.getString(STATE_RESULT_RECOVERED)
            val resultDeath = savedInstanceState.getString(STATE_RESULT_DEATH)
            val resultTreated = savedInstanceState.getString(STATE_RESULT_TREATED)
            binding.tvDescInfected.text = result
            binding.tvDescRecovered.text = resultRecovered
            binding.tvDescDeath.text = resultDeath
            binding.tvDescHospitallize.text = resultTreated
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isOnline(): Boolean {
        val conManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conManager.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            return false
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT_INFECTED, binding.tvDescInfected.text.toString())
        outState.putString(STATE_RESULT_DEATH, binding.tvDescDeath.text.toString())
        outState.putString(STATE_RESULT_TREATED, binding.tvDescHospitallize.text.toString())
        outState.putString(STATE_RESULT_RECOVERED, binding.tvDescRecovered.text.toString())
    }

    private fun showGlobal() {

        binding.rvGlobal.setHasFixedSize(true)
        binding.progressMain.visibility = View.VISIBLE

        RetrofitClient.instance.getGlobal().enqueue(object : Callback<ArrayList<globalResponse>> {
            override fun onResponse(
                call: Call<ArrayList<globalResponse>>,
                response: Response<ArrayList<globalResponse>>
            ) {
                val list = response.body()
                val globalAdapter = list?.let { GlobalAdapter(it) }
                binding.rvGlobal.adapter = globalAdapter
                valueGlobal = true
                binding.progressMain.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<ArrayList<globalResponse>>, t: Throwable) {
                Log.i("ErrorGlobal", t.message.toString())
                binding.progressMain.visibility = View.INVISIBLE
                if (t.message == "timeout") {
                    showGlobal()
                }

            }


        })
    }

    private fun showIndonesiaDaily() {
        binding.progressMain.visibility = View.VISIBLE

        RetrofitClient_Day.instance.getDailyAdd().enqueue(object : Callback<UpdateCorona> {
            override fun onResponse(call: Call<UpdateCorona>, response: Response<UpdateCorona>) {
                val responsenya = response.body()?.penambahan

                binding.tvCasesRecoveredDaily.text = responsenya?.RecoveredCases.toString()
                binding.tvCasesDeathDaily.text = responsenya?.DeathCases.toString()
                binding.tvCasesPositiveDaily.text = responsenya?.positiveCases.toString()
                binding.tvCasesTreatDaily.text = responsenya?.TreatCases.toString()
                binding.tvDateCaseDaily.text = responsenya?.tanggal.toString()
                valueDaily = true
                binding.progressMain.visibility = View.INVISIBLE

            }

            override fun onFailure(call: Call<UpdateCorona>, t: Throwable) {
                Log.d("error", t.message.toString())
                binding.progressMain.visibility = View.INVISIBLE
            }

        })

    }

    private fun showIndonesia() {
        binding.progressMain.visibility = View.VISIBLE

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
                binding.progressMain.visibility = View.INVISIBLE
                valueIndonesia = true
                binding.progressMain.visibility = View.INVISIBLE

            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Log.d("error", t.message.toString())
                binding.progressMain.visibility = View.INVISIBLE
                showIndonesia()

            }

        })
    }


}