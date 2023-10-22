package com.example.ahmedtw_1.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.ahmedtw_1.R
import com.example.ahmedtw_1.model.Massage


class Recycler() : Adapter<Recycler.ViewHolder>() {
    var list_massages: MutableList<Massage> = mutableListOf()
    var onListItemClick: OnListItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list_massages[position])
    }

    override fun getItemCount(): Int {
        return list_massages.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun set_items(list_massages: MutableList<Massage>) {
        this.list_massages = list_massages
        notifyDataSetChanged()
    }

   inner class ViewHolder(itewview: View) : RecyclerView.ViewHolder(itewview) {
        var imageView: ImageView = itewview.findViewById(R.id.img_item)
        var textView_name: TextView = itewview.findViewById(R.id.txt_name_item)
        var textview_Massage: TextView = itewview.findViewById(R.id.txt_massage_item)

        fun  bind(massage: Massage){
            imageView.setImageResource(massage.imageId)
            textView_name.text = massage.name
           textview_Massage.text = massage.massage

            itemView.setOnClickListener {
                onListItemClick?.onItemclick(massage)
            }
        }

    }

}