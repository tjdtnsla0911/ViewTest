package org.techtown.mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        //싱글톤

        auth = Firebase.auth

        val joinBtn = findViewById<Button>(R.id.joinArea)

        joinBtn.setOnClickListener {
            print("joinBtn클릭")

            val email = findViewById<EditText>(R.id.emailArea)
            val password = findViewById<EditText>(R.id.passwordArea)

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        //성공시여기
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("@@@@@@@@@@@@", "createUserWithEmail:success")
                            Toast.makeText(this,"성공하였습니다",Toast.LENGTH_SHORT).show()
                            var intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)

                            //실패시여기
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this,"실패하였습니다",Toast.LENGTH_SHORT).show()
                            Log.e("@@@@@@@ JoinActivity in : ",task.exception.toString())
                            
                        }
                    }




        }
    }
}