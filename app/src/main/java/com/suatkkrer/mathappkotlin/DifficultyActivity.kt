package com.suatkkrer.mathappkotlin

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val math = intent.getStringExtra("Math")

        if (math.equals("Addition")) {
            showLongToast("Addition")
        } else if (math.equals("Subtraction")){
            showLongToast("Subbbb")
        }

    }

    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

}