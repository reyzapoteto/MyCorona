package com.coronaapp.Activity.News_Hoax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.coronaapp.NewsActivity
import com.coronaapp.R
import com.coronaapp.adapter.Hoax.NewsAdapter
import com.coronaapp.api.Retrofit.RetrofitNewsCovid
import com.coronaapp.databinding.ActivityNewsCovidBinding
import com.coronaapp.model.Hoax.hoaxmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsCovidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_covid)
        binding = ActivityNewsCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imbtnBack.setOnClickListener {
            super.onBackPressed()
        }

        showNewsCovid()

    }

    private fun showNewsCovid() {
        binding.progNewsCovid.visibility = View.VISIBLE
        binding.rvCovidNews.setHasFixedSize(true)

        RetrofitNewsCovid.instance.getNews().enqueue(object : Callback<ArrayList<hoaxmodel>> {

            override fun onResponse(
                call: Call<ArrayList<hoaxmodel>>,
                response: Response<ArrayList<hoaxmodel>>
            ) {
                val list = response.body()
                val adapter = list?.let { NewsAdapter(it, this@NewsCovidActivity) }
                binding.rvCovidNews.adapter = adapter
                binding.progNewsCovid.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<ArrayList<hoaxmodel>>, t: Throwable) {
                Toast.makeText(this@NewsCovidActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.i("ErrorHoax", t.message.toString())
                binding.progNewsCovid.visibility = View.INVISIBLE              }


        })
    }
}