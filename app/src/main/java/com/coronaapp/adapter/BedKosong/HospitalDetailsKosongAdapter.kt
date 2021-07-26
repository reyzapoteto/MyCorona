package com.coronaapp.adapter.BedKosong

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.Activity.Bed_Covid.HospitalDetailsActivity
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong

class HospitalDetailsKosongAdapter(
    val activity: HospitalDetailsActivity,
    val listHospitalDetails: Hospital_Details_BedKosong
) : RecyclerView.Adapter<HospitalDetailsKosongAdapter.HospitalDetailsViewHolder>() {

    class HospitalDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalDetailsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HospitalDetailsViewHolder, position: Int) {

        val idHospitalsDetail = listHospitalDetails.data.id
        val nameHospitalDetails = listHospitalDetails.data.name
        val addressHospitalDetails = listHospitalDetails.data.address
        val phoneHospitalDetails = listHospitalDetails.data.phone

        val timeUpdate = listHospitalDetails.data.bedDetail[position].time
        val stas = listHospitalDetails.data.bedDetail[position].stats

        val titleBed = stas.title
        val bedTersedia = stas.bedTersedia
        val bedKosong = stas.bedKosong
        val antri = stas.queue
    }

    override fun getItemCount(): Int {
        return listHospitalDetails.data.bedDetail.size
    }

}