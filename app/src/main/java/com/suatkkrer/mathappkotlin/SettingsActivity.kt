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
    var savedNumber = 10
    var savedTime = 10000

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

    override fun onPause() {
        super.onPause()
        saveData()
    }

    fun saveData(){


        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putBoolean("BOOLEAN_SOUND",soundSwitch.isChecked)
            putBoolean("BOOLEAN_VIBRATION",vibrationSwitch.isChecked)
            putInt("QUESTION_NUMBER",questionNumber)
            putInt("QUESTION_TIME",questionTime)
        }.apply()
    }

    fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedSound = sharedPreferences.getBoolean("BOOLEAN_SOUND",false)
        val savedVibration = sharedPreferences.getBoolean("BOOLEAN_VIBRATION",false)
        savedNumber = sharedPreferences.getInt("QUESTION_NUMBER",10)
        savedTime = sharedPreferences.getInt("QUESTION_TIME",10000)

        soundSwitch.isChecked = savedSound
        vibrationSwitch.isChecked = savedVibration
    }



    fun saveSettings(view: View) {


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
                else -> {
                    questionNumber = savedNumber
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
                else -> {
                    questionTime = savedTime
                }
            }

            try {
                val sqliteDatabase: SQLiteDatabase =
                    this.openOrCreateDatabase("Settings", MODE_PRIVATE, null)

                sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (sound INTEGER, vibration INTEGER, question INTEGER, time INTEGER)")

                sqliteDatabase.execSQL("DELETE FROM settings")

                sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (sound INTEGER, vibration INTEGER, question INTEGER, time INTEGER)")

                sqliteDatabase.execSQL("INSERT INTO settings (sound, vibration, question, time) VALUES (${sou},${vib},${questionNumber},${questionTime})")

                showLongToast("Your Settings Have Been Saved")


            } catch (e : Exception){
                e.printStackTrace();
            }

        saveData()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()


    }

    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

    fun backButton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}