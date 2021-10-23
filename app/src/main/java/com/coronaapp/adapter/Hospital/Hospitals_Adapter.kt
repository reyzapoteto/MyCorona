package com.coronaapp.adapter.Hospital

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.R
import com.coronaapp.model.RumahSakitResponse

class Hospitals_Adapter(val listHospital: ArrayList<RumahSakitResponse>) :
    RecyclerView.Adapter<Hospitals_Adapter.Viewholder>() {

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvNameHospitals: TextView = view.findViewById(R.id.tvNameHospital)
        private val tvAddressHospitals: TextView = view.findViewById(R.id.tvAddressHospital)
        private val tvRegionHospitals: TextView = view.findViewById(R.id.tvRegionHospital)
        private val tvPhoneHospitals: TextView = view.findViewById(R.id.tvPhoneHospital)
        private val tvProvinceHospitals: TextView = view.findViewById(R.id.tvProvinceHospitals)

        fun bind(hospital: RumahSakitResponse) {
            tvNameHospitals.text = hospital.name
            tvAddressHospitals.text = hospital.address
            tvPhoneHospitals.text = hospital.phone
            tvProvinceHospitals.text = hospital.province
            tvRegionHospitals.text = hospital.region
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.hospitals_datamodel, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(listHospital[position])
    }

    override fun getItemCount(): Int {
        return listHospital.size
    }
}