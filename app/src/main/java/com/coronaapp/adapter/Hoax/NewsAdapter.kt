package com.coronaapp.adapter.Hoax

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.coronaapp.NewsActivity
import com.coronaapp.R
import com.coronaapp.model.Hoax.hoaxmodel

class NewsAdapter(
    private var list: ArrayList<hoaxmodel>,
    private var activity: AppCompatActivity
) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val background: ConstraintLayout = itemView.findViewById(R.id.backgroundHoax)
        val name: TextView = itemView.findViewById(R.id.tvTitleHoax)
        val image: ImageView = itemView.findViewById(R.id.imgNewsHoax)

        fun bind(hoax: hoaxmodel) {
            name.text = hoax.titleHoax

            background.setOnClickListener {
                val intent = Intent(activity, NewsActivity::class.java)
                intent.putExtra("url", hoax.newsUrlHoax)
                activity.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.hoax_datamodel, parent, false)
        return ViewHolder((view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}