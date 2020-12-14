package com.suatkkrer.mathappkotlin

import android.app.PendingIntent.getActivity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*



class SettingsActivity : AppCompatActivity() {

    lateinit var testActivity: TestActivity
    var sou : Int = 0
    var vib : Int = 0
    var questionNumber : Int = 10
    var questionTime : Int = 10000

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
                sou = 1
                saveData()
            } else {
                sou = 0
                saveData()
            }
            Log.e("sound",sou.toString())
        }

        vibrationSwitch.setOnCheckedChangeListener { compoundButton, onSwitch ->

            if (onSwitch){
                vib = 1
                saveData()
            } else {
                vib = 0
                saveData()
            }
            Log.e("vib",vib.toString())
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

    fun saveSettings(view: View) {

        if ((question10.isChecked || question20.isChecked || question30.isChecked) &&
            (time10.isChecked || time20.isChecked || time30.isChecked)) {

            when {
                question10.isChecked -> {
                    questionNumber = 10
                }
                question20.isChecked -> {
                    questionNumber = 20
                }
                question30.isChecked -> {
                    questionNumber = 30
                }
            }

            when {
                time10.isChecked -> {
                    questionTime = 10000
                } time20.isChecked -> {
                    questionTime = 20000
                } time30.isChecked -> {
                    questionTime = 30000
                }
            }

            val sqliteDatabase: SQLiteDatabase =
                this.openOrCreateDatabase("Settings", MODE_PRIVATE, null)

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (sound INTEGER, vibration INTEGER, question INTEGER, time INTEGER)")

            sqliteDatabase.execSQL("DELETE FROM settings")

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (sound INTEGER, vibration INTEGER, question INTEGER, time INTEGER)")

            sqliteDatabase.execSQL("INSERT INTO settings (sound, vibration, question, time) VALUES (${sou},${vib},${questionNumber},${questionTime})")

        } else {
            showLongToast("Please Select Question Number and Time")
        }

    }

    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}