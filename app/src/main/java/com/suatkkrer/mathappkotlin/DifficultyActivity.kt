package com.suatkkrer.mathappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_difficulty.*
import kotlinx.android.synthetic.main.activity_test.*

class DifficultyActivity : AppCompatActivity() {

    var math: String? = null
    var diff: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        // Flag removed
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setSupportActionBar(toolbar)

        math = intent.getStringExtra("Math")
        diff = intent.getStringExtra("difficulty")

        difficultyText.text = diff

    }

    fun Easy(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Easy")
            putExtra("Operator",math)
        }
        startActivity(intent)
    }
    fun Medium(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Medium")
            putExtra("Operator",math)
        }
        startActivity(intent)
    }
    fun Hard(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Hard")
            putExtra("Operator",math)
        }
        startActivity(intent)
    }
    fun Expert(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Expert")
            putExtra("Operator",math)
        }
        startActivity(intent)
    }

    fun Back(view: View) {

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)


    }

}