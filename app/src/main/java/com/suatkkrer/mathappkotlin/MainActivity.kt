package com.suatkkrer.mathappkotlin

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }


    fun Addition(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Addition")
            putExtra("difficulty","Addition")
        }
        startActivity(intent)
    }


    fun Subtraction(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Subtraction")
            putExtra("difficulty","Subtraction")
        }
        startActivity(intent)
    }


    fun Multiplication(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Multiplication")
            putExtra("difficulty","Multiplication")
        }
        startActivity(intent)
    }


    fun Division(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Division")
            putExtra("difficulty","Division")
        }
        startActivity(intent)
    }


    fun Mixed(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Mixed")
            putExtra("difficulty","Mixed")
        }
        startActivity(intent)
    }

    fun Quiz(view: View) {
        val intent = Intent(this,QuizActivity::class.java)
        startActivity(intent)
    }

    fun settings(view: View) {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    fun stars(view: View) {
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