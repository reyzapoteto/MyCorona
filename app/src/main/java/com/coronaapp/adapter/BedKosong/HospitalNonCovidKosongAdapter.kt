package com.coronaapp.adapter.BedKosong

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.model.Bed_Kosong.Hospitals_NonCovid.Hospital_Non_Corona_BedKosong


class HospitalNonCovidKosongAdapter(
    private val listHospitals: Hospital_Non_Corona_BedKosong,
    val activity: Activity,
    private val activityDestination: Activity
) : RecyclerView.Adapter<HospitalNonCovidKosongAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listHospitals.hospitals.size
    }
}