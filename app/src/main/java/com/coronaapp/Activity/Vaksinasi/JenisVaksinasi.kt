package com.coronaapp.Activity.Vaksinasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coronaapp.R
import com.coronaapp.databinding.ActivityJenisVaksinasiBinding
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.core.content.ContentProviderCompat.requireContext

import android.R.string.no
import androidx.core.content.ContentProviderCompat
import com.coronaapp.Object.VaccineData
import com.coronaapp.adapter.Vaksinasi.JenisVaksinasiAdapter
import com.coronaapp.model.Vaccine.jenisVaksinDatamodel


class JenisVaksinasi : AppCompatActivity() {

    private lateinit var binding: ActivityJenisVaksinasiBinding
    private lateinit var VaccineAdapter: JenisVaksinasiAdapter
    private var list: ArrayList<jenisVaksinDatamodel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisVaksinasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackJenisVaksin.setOnClickListener {
            Intent(this, VaccineActivity::class.java).also {
                startActivity(it)
            }
        }

        showRecylerview()

    }

    private fun showRecylerview() {
        list.addAll(VaccineData.listData)
        VaccineAdapter = JenisVaksinasiAdapter(list)
        binding.rvJenisVaksin.apply {
            layoutManager =
                LinearLayoutManager(this@JenisVaksinasi, LinearLayoutManager.HORIZONTAL, false)
            adapter = VaccineAdapter
            setHasFixedSize(true)
        }

    }
}