package com.example.espressotesting

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.MutableMap as MutableMap1

class MainActivity : AppCompatActivity() {
    lateinit var button_next_activity: Button
    lateinit var activity_main_title: TextView
    lateinit var remoteConfig: FirebaseRemoteConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_next_activity = findViewById(R.id.button_next_activity)
        activity_main_title = findViewById(R.id.activity_main_title)


        activity_main_title.setText("current version code" + getVersion())

        val defaultRate = mutableMapOf<String, Any?>()

        defaultRate.put("new_version_code", getVersion())

        remoteConfig = FirebaseRemoteConfig.getInstance()

        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .setFetchTimeoutInSeconds(60)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(defaultRate)

//        button_next_activity.setOnClickListener({
//
//            var intent = Intent(this, SeconderyActivity::class.java)
//            startActivity(intent)
//
//        })
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val new_version_code=remoteConfig.getString("new_version_code")
                    if (new_version_code.toInt() > getVersion()){
                        showDialogs(new_version_code)
                    }
                }
            }
    }

    private fun showDialogs(newVersionCode: String) {
        val dialog= AlertDialog.Builder(this)

        dialog.setTitle("Update available")
        dialog.setMessage("please update to new version of the app "+newVersionCode)
        dialog.setPositiveButton("update",null)
        dialog.setCancelable(false)

        dialog.setPositiveButton("Proceed", DialogInterface.OnClickListener {
                dialog, id -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_LONG).show()
        })

        dialog.show()


        
    }

    private fun getVersion(): Int {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        return packageInfo.versionCode
    }
}