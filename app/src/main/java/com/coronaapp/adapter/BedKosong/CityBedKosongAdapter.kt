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
import com.coronaapp.Activity.Bed_Covid.HospitalActivity
import com.coronaapp.R
import com.coronaapp.model.Bed_Kosong.Cities.City_Corona_BedKosong
import org.w3c.dom.Text

class CityBedKosongAdapter(
    private val listCityBedKosong: City_Corona_BedKosong,
    val activity: Activity,
    private val activityDestination :Activity,
    private val idProvince:String
) : RecyclerView.Adapter<CityBedKosongAdapter.CityViewHolder>() {

    class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val background:ConstraintLayout = view.findViewById(R.id.background_CityBedKosong)
        val name :TextView = view.findViewById(R.id.tvTitleCityBedKosong)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layout  = LayoutInflater.from(parent.context).inflate(R.layout.city_bed_kosong_datamodel,parent,false)
        return CityViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val idCity = listCityBedKosong.cities[position].id

        holder.name.text = listCityBedKosong.cities[position].name

        holder.background.setOnClickListener {
            val intent = Intent(activity,activityDestination::class.java)
            intent.putExtra("idCity",idCity)
            intent.putExtra("idProvince",idProvince)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  listCityBedKosong.cities.size
    }
}