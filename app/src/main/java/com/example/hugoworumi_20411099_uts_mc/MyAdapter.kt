package com.example.hugoworumi_20411099_uts_mc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (
    private  val context : Context,
    private  val reseps : List<itemimg>,
    private val listener : (itemimg) -> Unit)
    : RecyclerView.Adapter<MyAdapter.WisataViewHolder>() {

    class WisataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.v_img)
        private val name = view.findViewById<TextView>(R.id.v_name)


        fun bindView(wisata: itemimg, listener: (itemimg) -> Unit) {
            image.setImageResource(wisata.img)
            name.text = wisata.name
            itemView.setOnClickListener { listener(wisata) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder =
        WisataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false))

    override fun getItemCount(): Int = reseps.size

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        holder.bindView(reseps[position], listener)
    }
}