package com.suatkkrer.mathappkotlin

import android.content.Intent
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
        }
        startActivity(intent)
    }


    fun Subtraction(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Subtraction")
        }
        startActivity(intent)
    }


    fun Multiplication(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Multiplication")
        }
        startActivity(intent)
    }


    fun Division(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Division")
        }
        startActivity(intent)
    }


    fun Mixed(view: View) {

        val intent = Intent(this, DifficultyActivity::class.java).apply {
            putExtra("Math","Mixed")
        }
        startActivity(intent)
    }

    fun Quiz(view: View) {
        val intent = Intent(this,QuizActivity::class.java)
        startActivity(intent)
    }


}