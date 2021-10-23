package com.coronaapp.adapter.BedKosong

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.Activity.Bed_Covid.HospitalDetailsActivity
import com.coronaapp.R
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong

class HospitalDetailsKosongAdapter(
    val activity: Activity,
    private val listHospitalDetails: Hospital_Details_BedKosong
) : RecyclerView.Adapter<HospitalDetailsKosongAdapter.HospitalDetailsViewHolder>() {

    class HospitalDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitleBed)
        val tvBedAvailable: TextView = itemView.findViewById(R.id.tvBedAvailableHospitalDetails)
        val tvBedEmpty: TextView = itemView.findViewById(R.id.tvBedKosongHospitalDetails)
        val tvQueue: TextView = itemView.findViewById(R.id.tvQueueHospitalDetails)
        val tvDataUpdated: TextView = itemView.findViewById(R.id.tvDataUpdated)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalDetailsViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.hospital_details_bedkosong_datamodel, parent, false)
        return HospitalDetailsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HospitalDetailsViewHolder, position: Int) {
        val timeUpdate = listHospitalDetails.data.bedDetail[position].time
        val stas = listHospitalDetails.data.bedDetail[position].stats

        val titleBed = stas.title
        val bedTersedia = stas.bedTersedia
        val bedKosong = stas.bedKosong
        val antri = stas.queue

        holder.tvTitle.text = titleBed
        holder.tvBedAvailable.text = bedTersedia.toString()
        holder.tvBedEmpty.text = bedKosong.toString()
        holder.tvQueue.text = antri.toString()
        holder.tvDataUpdated.text = timeUpdate

    }

    override fun getItemCount(): Int {
        return listHospitalDetails.data.bedDetail.size
    }

}