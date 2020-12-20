package com.suatkkrer.mathappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_graphic.*

class GraphicActivity : AppCompatActivity() {

    var trueQuestion : Int? = null
    var falseQuestion : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphic)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        falseQuestion = intent.getIntExtra("False",-1)
        trueQuestion = intent.getIntExtra("True",-1)



        if (trueQuestion != -1 && falseQuestion != -1){

            textView3.text = "$trueQuestion"




            textView4.text = "$falseQuestion"
        }

    }
}