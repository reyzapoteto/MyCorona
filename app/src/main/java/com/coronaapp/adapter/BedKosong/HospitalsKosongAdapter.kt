package com.coronaapp.adapter.BedKosong

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.Activity.Bed_Covid.HospitalActivity
import com.coronaapp.Activity.Bed_Covid.HospitalDetailsActivity
import com.coronaapp.Activity.HospitalsActivity
import com.coronaapp.R
import com.coronaapp.model.Bed_Kosong.Hospitals.Hospital_Corona_BedKosong

class HospitalsKosongAdapter(
    private val listHospitals: Hospital_Corona_BedKosong,
    val activity: Activity,
    private val activityDestination :Activity
)

    : RecyclerView.Adapter<HospitalsKosongAdapter.HospitalViewHolder>() {

    class HospitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val backgroundHospitals: CardView = itemView.findViewById(R.id.backgroundHospitals)
        val tvHospitals: TextView = itemView.findViewById(R.id.tvHospitalsName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocationHospital)
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhoneHospital)
        val tvUpdate: TextView = itemView.findViewById(R.id.tvDataUpload)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.hospitals_bed_kosong_datamodel, parent, false)
        return HospitalViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.tvHospitals.text = listHospitals.hospitals[position].name
        holder.tvLocation.text = listHospitals.hospitals[position].address
        holder.tvPhone.text = listHospitals.hospitals[position].phone
        holder.tvUpdate.text = listHospitals.hospitals[position].info

        holder.backgroundHospitals.setOnClickListener {
            val idHospitals = listHospitals.hospitals[position].id
            val intent = Intent(activity, activityDestination::class.java)
            intent.putExtra("idHospital", idHospitals)
            activity.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listHospitals.hospitals.size
    }
}