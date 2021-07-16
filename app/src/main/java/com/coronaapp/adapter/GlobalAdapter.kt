package com.coronaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.R
import com.coronaapp.model.globalResponse
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class GlobalAdapter(private val listGlobal:ArrayList<globalResponse>):RecyclerView.Adapter<GlobalAdapter.GlobalViewHolder>() {

    class GlobalViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        private val tvNumberCountry:TextView =itemview.findViewById(R.id.tvGlobalNumber)
        private val tvNameCountry:TextView = itemview.findViewById(R.id.tvGlobalNameCountry)
        private val tvCasePositive:TextView = itemview.findViewById(R.id.tvGlobalCasePositive)
        private val tvCaseNegative:TextView = itemview.findViewById(R.id.tvGlobalCaseNegative)
        private val tvCaseDeath:TextView = itemview.findViewById(R.id.tvGlobalCaseDeath)
        private val numberFormat = NumberFormat.getCurrencyInstance()


        fun bind(global: globalResponse) {
            tvNumberCountry.text = global.attributes.objectID.toString()
            tvNameCountry.text = global.attributes.countryName
            tvCasePositive.text = global.attributes.caseConfirmed.toString()
            tvCaseNegative.text =global.attributes.caseRecovered.toString()
            tvCaseDeath.text = global.attributes.caseDeath.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlobalViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.global_datamodel,parent,false)
        return GlobalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GlobalViewHolder, position: Int) {
        holder.bind(listGlobal[position])
    }

    override fun getItemCount(): Int {
        return listGlobal.size
    }
}