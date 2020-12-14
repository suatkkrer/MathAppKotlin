package com.suatkkrer.mathappkotlin

import android.app.PendingIntent.getActivity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*



class SettingsActivity : AppCompatActivity() {

    lateinit var testActivity: TestActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        testActivity = TestActivity()


        loadData()


        soundSwitch.setOnCheckedChangeListener { compoundButton, onSwitch ->

            if (onSwitch){
                saveData()
            } else {

                saveData()
            }
        }

        vibrationSwitch.setOnCheckedChangeListener { compoundButton, onSwitch ->

            if (onSwitch){
                saveData()
            } else {
                saveData()
            }
        }
    }

    fun saveData(){


        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putBoolean("BOOLEAN_SOUND",soundSwitch.isChecked)
            putBoolean("BOOLEAN_VIBRATION",vibrationSwitch.isChecked)
        }.apply()
    }

    fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedSound = sharedPreferences.getBoolean("BOOLEAN_SOUND",false)
        val savedVibration = sharedPreferences.getBoolean("BOOLEAN_VIBRATION",false)

        soundSwitch.isChecked = savedSound
        vibrationSwitch.isChecked = savedVibration
    }

    fun rateApp(view: View) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + this.packageName)
                )
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.packageName)
                )
            )
        }
    }
}