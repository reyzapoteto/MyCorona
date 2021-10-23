package com.coronaapp.adapter.BedKosong

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.Activity.Bed_Covid.CityActivity
import com.coronaapp.Activity.Bed_Covid.ProvinceActivity
import com.coronaapp.R
import com.coronaapp.model.Bed_Kosong.All_Provinces.Corona_Bed_Kosong

class ProvinceBedKosongAdapter(private val listProvinceBedKosong:Corona_Bed_Kosong,
                               private val activity:Activity,
                               private val activityDestination :Activity
) :RecyclerView.Adapter<ProvinceBedKosongAdapter.ProvinceViewholder>(){

    class ProvinceViewholder(view :View):RecyclerView.ViewHolder(view){
        val background:ConstraintLayout = view.findViewById(R.id.background_ProvinceBedKosong)
        val tvTitleProvince:TextView = view.findViewById(R.id.tvTitleProvinceBedKosong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.province_bed_kosong_datamodel,parent,false)
        return ProvinceViewholder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewholder, position: Int) {
        holder.tvTitleProvince.text = listProvinceBedKosong.provinces[position].name
        val idProvince = listProvinceBedKosong.provinces[position].id

        holder.background.setOnClickListener {
            val intent = Intent(activity,activityDestination::class.java)
            intent.putExtra("idProvince",idProvince)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return  listProvinceBedKosong.provinces.size
    }
}