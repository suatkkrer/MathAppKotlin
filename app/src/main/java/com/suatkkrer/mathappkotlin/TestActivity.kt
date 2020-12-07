package com.suatkkrer.mathappkotlin

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    var math : String? = null
    var difficult : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        closeKeyboard()

        math = intent.getStringExtra("Operator")
        difficult = intent.getStringExtra("Difficulty")


        if (math.equals("Addition")){
            operator.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_add_24))
        } else if (math.equals("Subtraction")){
            operator.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_remove_24))
        } else if (math.equals("Multiplication")){
            operator.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_clear_24))
        } else if (math.equals("Division")){
            operator.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.divide))
        }

        randomMethod()


    }

    fun randomMethod(){
        if (difficult.equals("Easy")){
            val firstNumber = (0..100).random()
            val secondNumber = (0..100).random()
            if (math.equals("Subtraction") && firstNumber < secondNumber){
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()
            } else {
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }

        } else if (difficult.equals("Medium")){
            val firstNumber = (100..500).random()
            val secondNumber = (100..500).random()
            if (math.equals("Subtraction") && firstNumber < secondNumber){
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()
            } else {
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
        } else if (difficult.equals("Hard")){
            val firstNumber = (500..2000).random()
            val secondNumber = (500..2000).random()
            if (math.equals("Subtraction") && firstNumber < secondNumber){
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()
            } else {
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
        } else if (difficult.equals("Expert")){
            val firstNumber = (2000..50000).random()
            val secondNumber = (2000..50000).random()
            if (math.equals("Subtraction") && firstNumber < secondNumber){
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()
            } else {
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
        }
    }

    fun btn1(view: View) {
        numberText.append("1")
    }
    fun btn2(view: View) {
        numberText.append("2")
    }
    fun btn3(view: View) {
        numberText.append("3")
    }
    fun btn4(view: View) {
        numberText.append("4")
    }
    fun btn5(view: View) {
        numberText.append("5")
    }
    fun btn6(view: View) {
        numberText.append("6")
    }
    fun btn7(view: View) {
        numberText.append("7")
    }
    fun btn8(view: View) {
        numberText.append("8")
    }
    fun btn9(view: View) {
        numberText.append("9")
    }
    fun btnBack(view: View) {
        var textString = numberText.text.toString()
        if (textString.isNotEmpty()){
            numberText.text = textString.substring(0, textString.length - 1).toEditable()
        }
    }
    fun btn0(view: View) {
        numberText.append("0")
    }
    fun btnDone(view: View) {
        when {
            math.equals("Addition") -> {

                val numberFirst = Integer.parseInt(number1.text.toString())
                val numberSecond = Integer.parseInt(number2.text.toString())
                val totalNumber = Integer.parseInt(numberText.text.toString())

                if ((numberFirst + numberSecond) == totalNumber){
                    randomMethod()
                    numberText.text = ""
                } else {
                    showLongToast("Yanlis")
                }

            }
            math.equals("Subtraction") -> {

                val numberFirst = Integer.parseInt(number1.text.toString())
                val numberSecond = Integer.parseInt(number2.text.toString())
                val totalNumber = Integer.parseInt(numberText.text.toString())

                if ((numberFirst - numberSecond) == totalNumber){
                    randomMethod()
                    numberText.text = ""
                } else {
                    showLongToast("Yanlis")
                }

            }
            math.equals("Multiplication") -> {

                val numberFirst = Integer.parseInt(number1.text.toString())
                val numberSecond = Integer.parseInt(number2.text.toString())
                val totalNumber = Integer.parseInt(numberText.text.toString())

                if ((numberFirst * numberSecond) == totalNumber){
                    randomMethod()
                    numberText.text = ""
                } else {
                    showLongToast("Yanlis")
                }

            }
            math.equals("Division") -> {

                val numberFirst = Integer.parseInt(number1.text.toString())
                val numberSecond = Integer.parseInt(number2.text.toString())
                val totalNumber = Integer.parseInt(numberText.text.toString())

                if ((numberFirst / numberSecond) == totalNumber){
                    randomMethod()
                    numberText.text = ""
                } else {
                    showLongToast("Yanlis")
                }

            }
        }
    }


    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showLongToast(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

}