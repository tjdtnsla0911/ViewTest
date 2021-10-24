package org.techtown.mango

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVadaper(var items : MutableList<ContentModel>):RecyclerView.Adapter<RVadaper.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVadaper.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVadaper.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : ContentModel){
            var rv_img =itemView.findViewById<ImageView>(R.id.rvImageArea)
            var rv_text =itemView.findViewById<TextView>(R.id.rvTextArea)

            rv_text.text = item.title
            //글라이드!

   


        }
    }
}