package org.techtown.mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class HandlerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_view)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        },4000)
    }
}