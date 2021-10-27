package org.techtown.mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HandlerView : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_view)

        Toast.makeText(this,"StartMyApp",Toast.LENGTH_SHORT).show()

        auth = Firebase.auth
        Log.e("####### uid  = ",auth.currentUser?.uid.toString())

        if(auth.currentUser?.uid == null){

            Handler().postDelayed({
                startActivity(Intent(this,JoinActivity::class.java))
            },4000)
            //회원가입이 안되있다.
        }else{
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
            },4000)
            //회원가입되있다.
        }

    }
}