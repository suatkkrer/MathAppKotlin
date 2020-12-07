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

    private var math : String? = null
    private var difficult : String? = null
    private val randOperator = arrayOf(R.drawable.ic_baseline_add_24,R.drawable.ic_baseline_remove_24,R.drawable.ic_baseline_clear_24,R.drawable.divide)
    private var randomImage = (0..3).random()

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
        } else if (math.equals("Mixed")) {
            operator.setImageDrawable(ContextCompat.getDrawable(this,randOperator[randomImage]))
        }

        randomMethod()


    }

    private fun randomMethod(){
        if (difficult.equals("Easy")){
            if(math.equals("Addition")){
                var firstNumber = (2..100).random()
                var secondNumber = (2..100).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Multiplication")){
                var firstNumber = (2..10).random()
                var secondNumber = (2..10).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Division")){
                while (true) {
                    var firstNumber = (2..100).random()
                    var secondNumber = (2..100).random()
                    if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                        break
                    }
                }
            }
            if (math.equals("Subtraction")) {
                var firstNumber = (2..100).random()
                var secondNumber = (2..100).random()
                if (firstNumber < secondNumber){
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()
               } else {
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
             }
            }
            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        var firstNumber = (2..100).random()
                        var secondNumber = (2..100).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    1 -> {
                        var firstNumber = (2..100).random()
                        var secondNumber = (2..100).random()
                        if (firstNumber < secondNumber){
                            number1.text = secondNumber.toString()
                            number2.text = firstNumber.toString()
                        } else {
                            number1.text = firstNumber.toString()
                            number2.text = secondNumber.toString()
                        }
                    }
                    2 -> {
                        var firstNumber = (2..10).random()
                        var secondNumber = (2..10).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    3 -> {
                        while (true) {
                            var firstNumber = (2..100).random()
                            var secondNumber = (2..100).random()
                            if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                                number1.text = firstNumber.toString()
                                number2.text = secondNumber.toString()
                                break
                            }
                        }
                    }
                }
            }

        } else if (difficult.equals("Medium")){
            if(math.equals("Addition")){
                var firstNumber = (100..500).random()
                var secondNumber = (100..500).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Multiplication")){
                val firstNumber = (2..50).random()
                val secondNumber = (2..50).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Division")){
                while (true) {
                    var firstNumber = (100..500).random()
                    var secondNumber = (100..500).random()
                    if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                        break
                    }
                }
            }
            if (math.equals("Subtraction")) {
                var firstNumber = (100..500).random()
                var secondNumber = (100..500).random()
                if (firstNumber < secondNumber) {
                    number1.text = secondNumber.toString()
                    number2.text = firstNumber.toString()
                } else {
                    number1.text = firstNumber.toString()
                    number2.text = secondNumber.toString()
                }
            }
            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        var firstNumber = (100..500).random()
                        var secondNumber = (100..500).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    1 -> {
                        var firstNumber = (100..500).random()
                        var secondNumber = (100..500).random()
                        if (firstNumber < secondNumber) {
                            number1.text = secondNumber.toString()
                            number2.text = firstNumber.toString()
                        } else {
                            number1.text = firstNumber.toString()
                            number2.text = secondNumber.toString()
                        }
                    }
                    2 -> {
                        val firstNumber = (2..50).random()
                        val secondNumber = (2..50).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    3 -> {
                        while (true) {
                            var firstNumber = (100..500).random()
                            var secondNumber = (100..500).random()
                            if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                                number1.text = firstNumber.toString()
                                number2.text = secondNumber.toString()
                                break
                            }
                        }
                    }
                }
            }
        } else if (difficult.equals("Hard")){
            if(math.equals("Addition")){
                var firstNumber = (500..2000).random()
                var secondNumber = (500..2000).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Multiplication")){
                var firstNumber = (10..150).random()
                var secondNumber = (10..150).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Division")){
                while (true) {
                    var firstNumber = (500..2000).random()
                    var secondNumber = (500..2000).random()
                    if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                        break
                    }
                }
            }
            if (math.equals("Subtraction")) {
                var firstNumber = (500..2000).random()
                var secondNumber = (500..2000).random()
                if (firstNumber < secondNumber) {
                    number1.text = secondNumber.toString()
                    number2.text = firstNumber.toString()
                } else {
                    number1.text = firstNumber.toString()
                    number2.text = secondNumber.toString()
                }
            }
            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        var firstNumber = (500..2000).random()
                        var secondNumber = (500..2000).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    1 -> {
                        var firstNumber = (500..2000).random()
                        var secondNumber = (500..2000).random()
                        if (firstNumber < secondNumber) {
                            number1.text = secondNumber.toString()
                            number2.text = firstNumber.toString()
                        } else {
                            number1.text = firstNumber.toString()
                            number2.text = secondNumber.toString()
                        }
                    }
                    2 -> {
                        var firstNumber = (10..150).random()
                        var secondNumber = (10..150).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    3 -> {
                        while (true) {
                            var firstNumber = (500..2000).random()
                            var secondNumber = (500..2000).random()
                            if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                                number1.text = firstNumber.toString()
                                number2.text = secondNumber.toString()
                                break
                            }
                        }
                    }
                }
            }
        } else if (difficult.equals("Expert")){

            if(math.equals("Addition")){
                var firstNumber = (2000..50000).random()
                var secondNumber = (2000..50000).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }
            if (math.equals("Multiplication")){
                var firstNumber = (100..1000).random()
                var secondNumber = (100..1000).random()
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            }

            if (math.equals("Division")){
                while (true) {
                    var firstNumber = (200..50000).random()
                    var secondNumber = (200..50000).random()
                    if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                        break
                    }
                }
            }
            if (math.equals("Subtraction")) {
                var firstNumber = (2000..50000).random()
                var secondNumber = (2000..50000).random()
                if (firstNumber < secondNumber) {
                    number1.text = secondNumber.toString()
                    number2.text = firstNumber.toString()
                } else {
                    number1.text = firstNumber.toString()
                    number2.text = secondNumber.toString()
                }
            }
            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        var firstNumber = (2000..50000).random()
                        var secondNumber = (2000..50000).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    1 -> {
                        var firstNumber = (2000..50000).random()
                        var secondNumber = (2000..50000).random()
                        if (firstNumber < secondNumber) {
                            number1.text = secondNumber.toString()
                            number2.text = firstNumber.toString()
                        } else {
                            number1.text = firstNumber.toString()
                            number2.text = secondNumber.toString()
                        }
                    }
                    2 -> {
                        var firstNumber = (100..1000).random()
                        var secondNumber = (100..1000).random()
                        number1.text = firstNumber.toString()
                        number2.text = secondNumber.toString()
                    }
                    3 -> {
                        while (true) {
                            var firstNumber = (200..50000).random()
                            var secondNumber = (200..50000).random()
                            if (firstNumber > secondNumber && firstNumber % secondNumber == 0) {
                                number1.text = firstNumber.toString()
                                number2.text = secondNumber.toString()
                                break
                            }
                        }
                    }
                }
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
            math.equals("Mixed") -> {

                when (randomImage) {
                    0 -> {
                        val numberFirst = Integer.parseInt(number1.text.toString())
                        val numberSecond = Integer.parseInt(number2.text.toString())
                        val totalNumber = Integer.parseInt(numberText.text.toString())

                        if ((numberFirst + numberSecond) == totalNumber){
                            randomMethod()
                            randomImage = (0..3).random()
                            operator.setImageDrawable(ContextCompat.getDrawable(this,randOperator[randomImage]))
                            numberText.text = ""
                        } else {
                            showLongToast("Yanlis")
                        }
                    }
                    1 -> {
                        val numberFirst = Integer.parseInt(number1.text.toString())
                        val numberSecond = Integer.parseInt(number2.text.toString())
                        val totalNumber = Integer.parseInt(numberText.text.toString())

                        if ((numberFirst - numberSecond) == totalNumber){
                            randomMethod()
                            randomImage = (0..3).random()
                            operator.setImageDrawable(ContextCompat.getDrawable(this,randOperator[randomImage]))
                            numberText.text = ""
                        } else {
                            showLongToast("Yanlis")
                        }
                    }
                    2 -> {
                        val numberFirst = Integer.parseInt(number1.text.toString())
                        val numberSecond = Integer.parseInt(number2.text.toString())
                        val totalNumber = Integer.parseInt(numberText.text.toString())

                        if ((numberFirst * numberSecond) == totalNumber){
                            randomMethod()
                            randomImage = (0..3).random()
                            operator.setImageDrawable(ContextCompat.getDrawable(this,randOperator[randomImage]))
                            numberText.text = ""
                        } else {
                            showLongToast("Yanlis")
                        }
                    }
                    3 -> {
                        val numberFirst = Integer.parseInt(number1.text.toString())
                        val numberSecond = Integer.parseInt(number2.text.toString())
                        val totalNumber = Integer.parseInt(numberText.text.toString())

                        if ((numberFirst / numberSecond) == totalNumber){
                            randomMethod()
                            randomImage = (0..3).random()
                            operator.setImageDrawable(ContextCompat.getDrawable(this,randOperator[randomImage]))
                            numberText.text = ""
                        } else {
                            showLongToast("Yanlis")
                        }
                    }
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