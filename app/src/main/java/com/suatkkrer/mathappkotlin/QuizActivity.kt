package com.suatkkrer.mathappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var operation : String? = null
    private var diff : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

    }

    fun quizToTest(view: View) {

        when {
            additionRadioButton.isChecked -> {
                operation = "add"
            }
            subtractionRadioButton.isChecked -> {
                operation = "sub"
            }
            multiplyRadioButton.isChecked -> {
                operation = "multiply"
            }
            divisionRadioButton.isChecked -> {
                operation = "division"
            }
            mixedRadioButton.isChecked -> {
                operation = "mixed"
            }
        }

        when {
            easyRadioButton.isChecked -> {
                diff = "easy"
            }
            mediumRadioButton.isChecked -> {
                diff = "medium"
            }
            hardRadioButton.isChecked -> {
                diff = "hard"
            }
            expertRadioButton.isChecked -> {
                diff = "expert"
            }
        }


        if ((additionRadioButton.isChecked || subtractionRadioButton.isChecked ||
                        multiplyRadioButton.isChecked || divisionRadioButton.isChecked || mixedRadioButton.isChecked) &&
                (easyRadioButton.isChecked || mediumRadioButton.isChecked ||
                        hardRadioButton.isChecked || expertRadioButton.isChecked)){

            val intent = Intent(this,TestActivity::class.java).apply {
                putExtra("Operation",operation)
                putExtra("Diff",diff)
            }
            startActivity(intent)
        } else {
            showLongToast("Please Select Math Operation and Difficulty Level")
        }

    }


    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}