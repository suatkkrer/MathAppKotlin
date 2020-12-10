package com.suatkkrer.mathappkotlin

import android.content.Intent
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
    private var operation : String? = null
    private var diff : String? = null
    private val randOperator = arrayOf(R.drawable.ic_baseline_add_24,R.drawable.ic_baseline_remove_24,R.drawable.ic_baseline_clear_24,R.drawable.divide)
    private var randomImage = (0..3).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setSupportActionBar(toolbar)

        closeKeyboard()

        math = intent.getStringExtra("Operator")
        difficult = intent.getStringExtra("Difficulty")
        operation = intent.getStringExtra("Operation")
        diff = intent.getStringExtra("Diff")

        Log.e("Operation", operation.toString())
        Log.e("Diff", diff.toString())


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

            if(math.equals("Addition"))
            additionRandom(2,100)

            if (math.equals("Subtraction"))
            subtractionRandom(2,100)

            if (math.equals("Multiplication"))
            multiplicationRandom(2,10)

            if (math.equals("Division"))
            divisionRandom(21,100,2,20)

            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(2,100)
                    }
                    1 -> {
                        subtractionRandom(2,100)
                    }
                    2 -> {
                        multiplicationRandom(2,10)
                    }
                    3 -> {
                        divisionRandom(21,100,2,20)
                    }
                }
            }

        } else if (difficult.equals("Medium")){

            if(math.equals("Addition"))
            additionRandom(100,500)

            if (math.equals("Subtraction"))
            subtractionRandom(100,500)

            if (math.equals("Multiplication"))
            multiplicationRandom(2,50)

            if (math.equals("Division"))
            divisionRandom(201,500,50,200)

            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(100,500)
                    }
                    1 -> {
                        subtractionRandom(100,500)
                    }
                    2 -> {
                        multiplicationRandom(2,50)
                    }
                    3 -> {
                        divisionRandom(201,500,50,200)
                    }
                }
            }
        } else if (difficult.equals("Hard")){

            if(math.equals("Addition"))
            additionRandom(500,2000)

            if (math.equals("Subtraction"))
            subtractionRandom(500,2000)

            if (math.equals("Multiplication"))
            multiplicationRandom(10,150)

            if (math.equals("Division"))
            divisionRandom(501,2000,2,500)

            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(500,2000)
                    }
                    1 -> {
                        subtractionRandom(500,2000)
                    }
                    2 -> {
                        multiplicationRandom(10,150)
                    }
                    3 -> {
                        divisionRandom(501,2000,2,500)
                    }
                }
            }
        } else if (difficult.equals("Expert")){

            if(math.equals("Addition"))
            additionRandom(2000,50000)

            if (math.equals("Subtraction"))
            subtractionRandom(2000,50000)

            if (math.equals("Multiplication"))
            multiplicationRandom(100,1000)

            if (math.equals("Division"))
            divisionRandom(201,50000,2,200)

            if (math.equals("Mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(2000,50000)
                    }
                    1 -> {
                        subtractionRandom(2000,50000)
                    }
                    2 -> {
                        multiplicationRandom(100,1000)
                    }
                    3 -> {
                        divisionRandom(201,50000,2,200)
                    }
                }
            }
        }
    }

    fun additionRandom(numberFirst : Int, numberSecond : Int){

            var firstNumber = (numberFirst..numberSecond).random()
            var secondNumber = (numberFirst..numberSecond).random()
            number1.text = firstNumber.toString()
            number2.text = secondNumber.toString()
    }

    private fun subtractionRandom(numberFirst : Int, numberSecond : Int){

            var firstNumber = (numberFirst..numberSecond).random()
            var secondNumber = (numberFirst..numberSecond).random()
            if (firstNumber > secondNumber){
                number1.text = firstNumber.toString()
                number2.text = secondNumber.toString()
            } else {
                number1.text = secondNumber.toString()
                number2.text = firstNumber.toString()

            }
    }

    fun multiplicationRandom(numberFirst : Int, numberSecond : Int){
        var firstNumber = (numberFirst..numberSecond).random()
        var secondNumber = (numberFirst..numberSecond).random()
        number1.text = firstNumber.toString()
        number2.text = secondNumber.toString()

    }

    fun divisionRandom(numberFirst : Int, numberSecond : Int,numberThird : Int,numberFourth : Int){

            var firstNumber = (numberFirst..numberSecond).random()
            var secondNumber = (numberThird..numberFourth).random()
            while (firstNumber % secondNumber != 0) {
                firstNumber = (numberFirst..numberSecond).random()
                secondNumber = (numberThird..numberFourth).random()
            }
            number1.text = firstNumber.toString()
            number2.text = secondNumber.toString()

    }

    fun btn0(view: View) {
        numberText.append("0")
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

    fun btnDone(view: View) {
        if (numberText.text.toString() != "") {
            when {
                math.equals("Addition") -> {

                    val numberFirst = Integer.parseInt(number1.text.toString())
                    val numberSecond = Integer.parseInt(number2.text.toString())
                    val totalNumber = Integer.parseInt(numberText.text.toString())

                    if ((numberFirst + numberSecond) == totalNumber) {
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

                    if ((numberFirst - numberSecond) == totalNumber) {
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

                    if ((numberFirst * numberSecond) == totalNumber) {
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

                    if ((numberFirst / numberSecond) == totalNumber) {
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

                            if ((numberFirst + numberSecond) == totalNumber) {
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                            }
                        }
                        1 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst - numberSecond) == totalNumber) {
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                            }
                        }
                        2 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst * numberSecond) == totalNumber) {
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                            }
                        }
                        3 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst / numberSecond) == totalNumber) {
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                            }
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

    fun Skip(view: View) {
        if (math.equals("Mixed")){

            randomImage = (0..3).random()
            operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))

        }

        randomMethod()

        numberText.text = ""
    }

    fun Back(view: View) {
        if (diff != null){
            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this,DifficultyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}