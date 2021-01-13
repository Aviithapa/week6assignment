package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var et_email:EditText
    private lateinit var et_password:EditText
    private lateinit var btn_login:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_Password)
        btn_login=findViewById(R.id.btn_login)

        btn_login.setOnClickListener {
            var email=et_email.text.toString()
            var password=et_password.text.toString()

            if(email == "softwarica" && password == "coventry"){
                Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG).show()
            }
        }
    }
}