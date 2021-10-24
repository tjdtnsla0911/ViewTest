package org.techtown.mango

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 1..20){
            items.add(
                ContentModel(
                    "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                    "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                    "오스틴${i}"
                )
            )
        }


        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = RVadaper(items)

        recyclerView.layoutManager = GridLayoutManager(this,2)
        //1자리뽑는거
//        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}