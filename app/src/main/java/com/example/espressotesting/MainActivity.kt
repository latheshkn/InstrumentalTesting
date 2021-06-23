package com.example.espressotesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var button_next_activity: Button
    lateinit var activity_main_title: TextView
    lateinit var remoteConfig: FirebaseRemoteConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_next_activity = findViewById(R.id.button_next_activity)
        activity_main_title = findViewById(R.id.activity_main_title)

        remoteConfig= FirebaseRemoteConfig.getInstance()

        activity_main_title.setText("current version code"+getVersion())

        
//        button_next_activity.setOnClickListener({
//
//            var intent = Intent(this, SeconderyActivity::class.java)
//            startActivity(intent)
//
//        })
    }

    private fun getVersion():Int{
        val packageInfo=packageManager.getPackageInfo(packageName,0)
        return packageInfo.versionCode
    }
}