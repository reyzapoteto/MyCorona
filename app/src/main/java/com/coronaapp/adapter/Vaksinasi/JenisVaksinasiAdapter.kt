package com.coronaapp.adapter.Vaksinasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coronaapp.R
import com.coronaapp.model.Vaccine.jenisVaksinDatamodel

class JenisVaksinasiAdapter(private val listData: ArrayList<jenisVaksinDatamodel>) :
    RecyclerView.Adapter<JenisVaksinasiAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgVaksin: ImageView = itemView.findViewById(R.id.imgVaksin)
        private val tvVaccineName: TextView = itemView.findViewById(R.id.tvTitleVaccine)
        private val tvVaccinePlatform: TextView = itemView.findViewById(R.id.tvPlatform)
        private val tvVaccineDossage: TextView = itemView.findViewById(R.id.tvDosis)
        private val tvVaccineSpaceDossage: TextView = itemView.findViewById(R.id.tvJedaDosis)
        private val tvVaccineEfficiency: TextView = itemView.findViewById(R.id.tvEfektivitas)
        private val tvVaccineImpact: TextView = itemView.findViewById(R.id.tvEfeksamping)

        fun bind(jenis: jenisVaksinDatamodel) {
            Glide
                .with(itemView.context)
                .load(jenis.VaccineImage)
                .into(imgVaksin)
            tvVaccineName.text = jenis.VaccineName
            tvVaccinePlatform.text = jenis.VaccinePlatform
            tvVaccineDossage.text = jenis.VaccineDossage
            tvVaccineSpaceDossage.text = jenis.VaccineDossageSpace
            tvVaccineEfficiency.text = jenis.VaccineEfeciency
            tvVaccineImpact.text = jenis.VaccineImpact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vaksinasi_datamodel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}