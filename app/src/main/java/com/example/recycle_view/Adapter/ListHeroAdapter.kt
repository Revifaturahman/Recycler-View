package com.example.recycle_view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view.Model.Hero
import com.example.recycle_view.R

class ListHeroAdapter (private val listHero: ArrayList<Hero>,
            private val onItemClick: (Hero) -> Unit): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
         val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent,false)
         return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.txtName.text = name
        holder.txtDesc.text = desc
    }

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_hero)
        var txtName: TextView = itemView.findViewById(R.id.nama)
        var txtDesc: TextView = itemView.findViewById(R.id.desk)
    }
}


