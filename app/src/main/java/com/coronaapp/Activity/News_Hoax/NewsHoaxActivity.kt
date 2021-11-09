package com.coronaapp.Activity.News_Hoax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.coronaapp.R
import com.coronaapp.adapter.Hoax.NewsAdapter
import com.coronaapp.api.Retrofit.Retrofit_Hoax
import com.coronaapp.databinding.ActivityNewsHoaxBinding
import com.coronaapp.model.Hoax.hoaxmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsHoaxActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsHoaxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_hoax)
        binding = ActivityNewsHoaxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imbtnBack.setOnClickListener {
            super.onBackPressed()
        }

        showHoaxNews()
    }

    private fun showHoaxNews() {
        binding.progNewsHoax.visibility = View.VISIBLE
        binding.rvHoaxNews.setHasFixedSize(true)
        Retrofit_Hoax.instance.getHoax().enqueue(object : Callback<ArrayList<hoaxmodel>> {

            override fun onResponse(
                call: Call<ArrayList<hoaxmodel>>,
                response: Response<ArrayList<hoaxmodel>>
            ) {
                val list = response.body()
                val adapter = list?.let { NewsAdapter(it, this@NewsHoaxActivity) }
                binding.rvHoaxNews.adapter = adapter
                binding.progNewsHoax.visibility = View.INVISIBLE
            }


            override fun onFailure(call: Call<ArrayList<hoaxmodel>>, t: Throwable) {
                Toast.makeText(this@NewsHoaxActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.i("ErrorHoax", t.message.toString())
                binding.progNewsHoax.visibility = View.INVISIBLE
            }
        })
    }
}