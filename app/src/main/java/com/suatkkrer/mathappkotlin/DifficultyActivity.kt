package com.suatkkrer.mathappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DifficultyActivity : AppCompatActivity() {

    var math: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        math = intent.getStringExtra("Math")


    }

    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

    fun Easy(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Easy")
            putExtra("Operator",math)
        }
        startActivity(intent)
        finish()
    }
    fun Medium(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Medium")
            putExtra("Operator",math)
        }
        startActivity(intent)
        finish()
    }
    fun Hard(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Hard")
            putExtra("Operator",math)
        }
        startActivity(intent)
        finish()
    }
    fun Expert(view: View) {
        val intent = Intent(this,TestActivity::class.java).apply {
            putExtra("Difficulty","Expert")
            putExtra("Operator",math)
        }
        startActivity(intent)
        finish()
    }

}