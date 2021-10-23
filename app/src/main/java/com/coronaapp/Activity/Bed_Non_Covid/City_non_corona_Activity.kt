package com.coronaapp.Activity.Bed_Non_Covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coronaapp.adapter.BedKosong.CityBedKosongAdapter
import com.coronaapp.api.Retrofit.Retrofit_Bed_Kosong
import com.coronaapp.databinding.ActivityCityNonCoronaBinding
import com.coronaapp.model.Bed_Kosong.Cities.City_Corona_BedKosong
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class City_non_corona_Activity : AppCompatActivity() {

    private lateinit var bindig: ActivityCityNonCoronaBinding
    private lateinit var idProvince: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityCityNonCoronaBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        val intent = intent
        idProvince = intent.getStringExtra("idProvince")!!

        bindig.btnBackCityBedKosongNonCovid.setOnClickListener {
            super.onBackPressed()
        }

        showNonCovidCity()
    }

    private fun showNonCovidCity() {

        bindig.rvCityBedKosongNonCovid.setHasFixedSize(true)
        bindig.progCity.visibility = View.VISIBLE
        Retrofit_Bed_Kosong.instance.getCities(idProvince)
            .enqueue(object : Callback<City_Corona_BedKosong> {
                override fun onResponse(
                    call: Call<City_Corona_BedKosong>,
                    response: Response<City_Corona_BedKosong>
                ) {
                    val list = response.body()
                    val cityAdapter = list?.let {
                        CityBedKosongAdapter(
                            it,
                            this@City_non_corona_Activity,
                            Hospital_non_Covid_Activity(),
                            idProvince
                        )
                    }
                    bindig.rvCityBedKosongNonCovid.adapter = cityAdapter
                    bindig.progCity.visibility = View.INVISIBLE
                }

                override fun onFailure(call: Call<City_Corona_BedKosong>, t: Throwable) {
                    Toast.makeText(this@City_non_corona_Activity, t.message, Toast.LENGTH_SHORT)
                        .show()
                    bindig.progCity.visibility = View.INVISIBLE
                }

            })
    }
}