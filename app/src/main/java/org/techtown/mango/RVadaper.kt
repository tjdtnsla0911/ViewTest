package org.techtown.mango

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVadaper(val context : Context,var items : MutableList<ContentModel>):RecyclerView.Adapter<RVadaper.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVadaper.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(v)
    }

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick ? = null

    override fun onBindViewHolder(holder: RVadaper.ViewHolder, position: Int) {

        if(itemClick != null){
            holder?.itemView.setOnClickListener{v->
                itemClick!!.onClick(v,position)
            }
        }

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
            //context를 받아와야한다.
            Glide.with(context)
                    .load(item.titleImageUrl)
                    .into(rv_img) //어디에넣을꺼냐?
            //글라이드!
        }
    }
}