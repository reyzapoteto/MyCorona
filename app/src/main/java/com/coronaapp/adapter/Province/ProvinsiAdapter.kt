package com.coronaapp.adapter.Province

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.R
import com.coronaapp.model.Province.ProvinsiResponse

class ProvinsiAdapter(private var list: ArrayList<ProvinsiResponse>) :
    RecyclerView.Adapter<ProvinsiAdapter.provinsiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): provinsiViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.province_datamodel, parent, false)
        return provinsiViewHolder(view)
    }

    override fun onBindViewHolder(holder: provinsiViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class provinsiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvPositive:TextView = itemView.findViewById(R.id.tvCasesPositive)
        private val tvRecovered:TextView = itemView.findViewById(R.id.tvCasesRecovered)
        private val tvDeath:TextView = itemView.findViewById(R.id.tvCasesDeath)
        private val tvNameProvince:TextView = itemView.findViewById(R.id.tvProvinceName)

        fun bind(provinsi: ProvinsiResponse) {

            tvPositive.text = provinsi.attributes.casePositive.toString()
            tvDeath.text = provinsi.attributes.caseDeath.toString()
            tvNameProvince.text = provinsi.attributes.province
            tvRecovered.text = provinsi.attributes.caseRecovered.toString()
        }
    }
}