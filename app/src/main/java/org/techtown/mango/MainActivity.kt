package org.techtown.mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bookMarkButton = findViewById<Button>(R.id.bookMark)

        bookMarkButton.setOnClickListener{
            val intent = Intent(this,Bookmark_Activity::class.java)
            startActivity(intent)
        }

        items.add(
                ContentModel(
                    "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                    "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                    "오스틴"
                )
            )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/CVVJw_-7zG9b",
                        "https://mp-seoul-image-production-s3.mangoplate.com/389258/883806_1593340129409_16093?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "내자상회"
                )
        )

        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/ANFRhzAJWPhf",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1582398081502953.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "앙띠크"
                )
        )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/5DY203qKLaev",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1598434903111304.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "수타우동겐"
                )
        )
//////////////////////////


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                        "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "오스틴"
                )
        )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/CVVJw_-7zG9b",
                        "https://mp-seoul-image-production-s3.mangoplate.com/389258/883806_1593340129409_16093?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "내자상회"
                )
        )

        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/ANFRhzAJWPhf",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1582398081502953.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "앙띠크"
                )
        )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/5DY203qKLaev",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1598434903111304.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "수타우동겐"
                )
        )

        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/Gk7QsMOVDs",
                        "https://mp-seoul-image-production-s3.mangoplate.com/185802/epp-yngymd-zjj.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "오스틴"
                )
        )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/CVVJw_-7zG9b",
                        "https://mp-seoul-image-production-s3.mangoplate.com/389258/883806_1593340129409_16093?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "내자상회"
                )
        )

        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/ANFRhzAJWPhf",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1582398081502953.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "앙띠크"
                )
        )


        items.add(
                ContentModel(
                        "https://www.mangoplate.com/restaurants/5DY203qKLaev",
                        "https://mp-seoul-image-production-s3.mangoplate.com/619788_1598434903111304.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                        "수타우동겐"
                )
        )



        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVadaper(baseContext,items)
        recyclerView.adapter = rvAdapter


        rvAdapter.itemClick = object : RVadaper.ItemClick {
            override fun onClick(view: View, position: Int) {
                println("시발꺼")
                val intent =Intent(baseContext,ViewActivity::class.java)
                //더잦ㅇ해서보내기
                Toast.makeText(baseContext,items[position].title.toString() + "을 선택",Toast.LENGTH_SHORT).show()

                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].title)
                intent.putExtra("titleImageUrl",items[position].titleImageUrl)

                startActivity(intent)

            }
        }

        recyclerView.layoutManager = GridLayoutManager(this,2)
        //1자리뽑는거
//        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}