package org.techtown.mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth //uid필요해서 가져옴

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

       val webView = findViewById<WebView>(R.id.webView)
        println("webView ===="+webView.toString())
        webView.loadUrl(intent.getStringExtra("url").toString())

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val titleImageUrl = intent.getStringExtra("titleImageUrl").toString()

        // Write a message to the database
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref") //어디경로에 저장할꺼냐
        val saveText = findViewById<TextView>(R.id.save)

        saveText.setOnClickListener{

            myBookmarkRef
                    .child(auth.currentUser!!.uid) //
                    .push()
                    .setValue(ContentModel(url,titleImageUrl,title))
            Toast.makeText(this,"저장되었습니다!!!.",Toast.LENGTH_SHORT).show()
         }


    }



}