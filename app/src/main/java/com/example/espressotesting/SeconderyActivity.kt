package com.example.espressotesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SeconderyActivity : AppCompatActivity() {
    lateinit var button_back:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondery)
        button_back=findViewById(R.id.button_back);

        button_back.setOnClickListener({
           onBackPressed()
        })
    }
}