package com.example.retrofit_ilhamnr_15.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_ilhamnr_15.R
import com.example.retrofit_ilhamnr_15.model.ProvinceResponse


class  ProvinceAdapter(private  var list: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(Province: ProvinceResponse){
            with(itemView){

                val Name= findViewById<TextView>(R.id.tvName)
                val Positif = findViewById<TextView>(R.id.tvPositive)
                val Recover = findViewById<TextView>(R.id.tvRecover)
                val Death = findViewById<TextView>(R.id.tvDeath)


                Name.text = Province.attributes.province
                Positif.text = Province.attributes.positive.toString()
                Recover.text = Province.attributes.recover.toString()
                Death.text = Province.attributes.death.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return  ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}