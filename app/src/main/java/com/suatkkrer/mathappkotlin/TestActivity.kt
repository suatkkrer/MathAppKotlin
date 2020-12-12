package com.suatkkrer.mathappkotlin

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*


class TestActivity : AppCompatActivity() {

    private var math : String? = null
    private var difficult : String? = null
    private var operation : String? = null
    private var diff : String? = null
    private var vibrator: Vibrator? = null
    var question: Int = 0
    var animation : ObjectAnimator? = null
    private val randOperator = arrayOf(R.drawable.ic_baseline_add_24, R.drawable.ic_baseline_remove_24, R.drawable.ic_baseline_clear_24, R.drawable.divide)
    private var randomImage = (0..3).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        this.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setSupportActionBar(toolbar)

        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        math = intent.getStringExtra("Operator")
        difficult = intent.getStringExtra("Difficulty")
        operation = intent.getStringExtra("Operation")
        diff = intent.getStringExtra("Diff")

        Log.e("Operation", operation.toString())
        Log.e("Diff", diff.toString())

        if (math != null){
            when {
                math.equals("Addition") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_add_24))
                }
                math.equals("Subtraction") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_remove_24))
                }
                math.equals("Multiplication") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_clear_24))
                }
                math.equals("Division") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divide))
                }
                math.equals("Mixed") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                }
            }
        }

        if (operation != null){
            when {
                operation.equals("add") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_add_24))
                }
                operation.equals("sub") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_remove_24))
                }
                operation.equals("multiply") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_clear_24))
                }
                operation.equals("division") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divide))
                }
                operation.equals("mixed") -> {
                    operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                }
            }
        }


        randomMethod()

        if (operation != null) {

            progressBar.visibility = View.VISIBLE


            animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100)
            animation!!.duration = 15000
            animation!!.interpolator = DecelerateInterpolator()
            animation!!.addListener(object : Animator.AnimatorListener {

                override fun onAnimationStart(animator: Animator) {

                }

                override fun onAnimationEnd(animator: Animator) {
                    question++
                    Log.e("question", question.toString())
                    if (question != 10) {
                        randomMethod()
                        animation!!.start()
                        numberText.text = ""
                    } else {
                        progressBar.visibility = View.INVISIBLE
                        val intent1 = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent1)
                    }
                }

                override fun onAnimationCancel(animator: Animator) {

                }

                override fun onAnimationRepeat(animator: Animator) {

                }
            })
            animation!!.start()
        }

//        var counter : Int = 0
//        var question : Int = 0
//
//        t = Timer()
//        tt = object : TimerTask(){
//            override fun run() {
//                counter++
//                progressBar.progress = counter
//                if (counter == 100){
//                    question++
//                    counter = 0
//                    randomMethod()
//                }
//            }
//        }
//        t.schedule(tt, 0, 100)
//        Log.e("Question", question.toString())

    }

    private fun randomMethod(){

        if (difficult.equals("Easy") || diff.equals("easy")){

            if(math.equals("Addition") || operation.equals("add"))
            additionRandom(2, 100)

            if (math.equals("Subtraction") || operation.equals("sub"))
            subtractionRandom(2, 100)

            if (math.equals("Multiplication") || operation.equals("multiply"))
            multiplicationRandom(2, 10)

            if (math.equals("Division") || operation.equals("division"))
            divisionRandom(21, 100, 2, 20)

            if (math.equals("Mixed") || operation.equals("mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(2, 100)
                    }
                    1 -> {
                        subtractionRandom(2, 100)
                    }
                    2 -> {
                        multiplicationRandom(2, 10)
                    }
                    3 -> {
                        divisionRandom(21, 100, 2, 20)
                    }
                }
            }

        } else if (difficult.equals("Medium") || diff.equals("medium")){

            if(math.equals("Addition") || operation.equals("add"))
            additionRandom(100, 500)

            if (math.equals("Subtraction") || operation.equals("sub"))
            subtractionRandom(100, 500)

            if (math.equals("Multiplication") || operation.equals("multiply"))
            multiplicationRandom(2, 50)

            if (math.equals("Division") || operation.equals("division"))
            divisionRandom(201, 500, 50, 200)

            if (math.equals("Mixed") || operation.equals("mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(100, 500)
                    }
                    1 -> {
                        subtractionRandom(100, 500)
                    }
                    2 -> {
                        multiplicationRandom(2, 50)
                    }
                    3 -> {
                        divisionRandom(201, 500, 50, 200)
                    }
                }
            }
        } else if (difficult.equals("Hard") || diff.equals("hard")){

            if(math.equals("Addition") || operation.equals("add"))
            additionRandom(500, 2000)

            if (math.equals("Subtraction") || operation.equals("sub"))
            subtractionRandom(500, 2000)

            if (math.equals("Multiplication") || operation.equals("multiply"))
            multiplicationRandom(10, 150)

            if (math.equals("Division") || operation.equals("division"))
            divisionRandom(501, 2000, 2, 500)

            if (math.equals("Mixed") || operation.equals("mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(500, 2000)
                    }
                    1 -> {
                        subtractionRandom(500, 2000)
                    }
                    2 -> {
                        multiplicationRandom(10, 150)
                    }
                    3 -> {
                        divisionRandom(501, 2000, 2, 500)
                    }
                }
            }
        } else if (difficult.equals("Expert") || diff.equals("expert")){

            if(math.equals("Addition") || operation.equals("add"))
            additionRandom(2000, 50000)

            if (math.equals("Subtraction") || operation.equals("sub"))
            subtractionRandom(2000, 50000)

            if (math.equals("Multiplication") || operation.equals("multiply"))
            multiplicationRandom(100, 1000)

            if (math.equals("Division") || operation.equals("division"))
            divisionRandom(201, 50000, 2, 200)

            if (math.equals("Mixed") || operation.equals("mixed")){
                when(randomImage){
                    0 -> {
                        additionRandom(2000, 50000)
                    }
                    1 -> {
                        subtractionRandom(2000, 50000)
                    }
                    2 -> {
                        multiplicationRandom(100, 1000)
                    }
                    3 -> {
                        divisionRandom(201, 50000, 2, 200)
                    }
                }
            }
        }
    }

    fun additionRandom(numberFirst: Int, numberSecond: Int){

            var firstNumber = (numberFirst..numberSecond).random()
            var secondNumber = (numberFirst..numberSecond).random()
            number1.text = firstNumber.toString()
            number2.text = secondNumber.toString()
    }

    private fun subtractionRandom(numberFirst: Int, numberSecond: Int){

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

    fun multiplicationRandom(numberFirst: Int, numberSecond: Int){
        var firstNumber = (numberFirst..numberSecond).random()
        var secondNumber = (numberFirst..numberSecond).random()
        number1.text = firstNumber.toString()
        number2.text = secondNumber.toString()

    }

    fun divisionRandom(numberFirst: Int, numberSecond: Int, numberThird: Int, numberFourth: Int){

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
        if (numberText.text.toString() != "" && math != null) {
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
                        vibrator!!.vibrate(100)
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
                        vibrator!!.vibrate(100)
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
                        vibrator!!.vibrate(100)

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
                        vibrator!!.vibrate(100)

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
                                vibrator!!.vibrate(100)

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
                                vibrator!!.vibrate(100)

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
                                vibrator!!.vibrate(100)

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
                                vibrator!!.vibrate(100)

                            }
                        }
                    }
                }
            }
        } else if (numberText.text.toString() != "" && operation != null) {

            when {
                operation.equals("add") -> {

                    val numberFirst = Integer.parseInt(number1.text.toString())
                    val numberSecond = Integer.parseInt(number2.text.toString())
                    val totalNumber = Integer.parseInt(numberText.text.toString())

                    if ((numberFirst + numberSecond) == totalNumber) {
                        animation!!.end()
                        randomMethod()
                        numberText.text = ""
                    } else {
                        showLongToast("Yanlis")
                        vibrator!!.vibrate(1000)
                    }

                }
                operation.equals("sub")-> {

                    val numberFirst = Integer.parseInt(number1.text.toString())
                    val numberSecond = Integer.parseInt(number2.text.toString())
                    val totalNumber = Integer.parseInt(numberText.text.toString())

                    if ((numberFirst - numberSecond) == totalNumber) {
                        animation!!.end()
                        randomMethod()
                        numberText.text = ""
                    } else {
                        showLongToast("Yanlis")
                        vibrator!!.vibrate(1000)
                    }

                }
                operation.equals("multiply")-> {

                    val numberFirst = Integer.parseInt(number1.text.toString())
                    val numberSecond = Integer.parseInt(number2.text.toString())
                    val totalNumber = Integer.parseInt(numberText.text.toString())

                    if ((numberFirst * numberSecond) == totalNumber) {
                        animation!!.end()
                        randomMethod()
                        numberText.text = ""
                    } else {
                        showLongToast("Yanlis")
                        vibrator!!.vibrate(1000)

                    }

                }
                operation.equals("division")-> {

                    val numberFirst = Integer.parseInt(number1.text.toString())
                    val numberSecond = Integer.parseInt(number2.text.toString())
                    val totalNumber = Integer.parseInt(numberText.text.toString())

                    if ((numberFirst / numberSecond) == totalNumber) {
                        animation!!.end()
                        randomMethod()
                        numberText.text = ""
                    } else {
                        showLongToast("Yanlis")
                        vibrator!!.vibrate(1000)

                    }
                }
                operation.equals("mixed") -> {

                    when (randomImage) {
                        0 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst + numberSecond) == totalNumber) {
                                animation!!.end()
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                                vibrator!!.vibrate(1000)

                            }
                        }
                        1 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst - numberSecond) == totalNumber) {
                                animation!!.end()
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                                vibrator!!.vibrate(1000)

                            }
                        }
                        2 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst * numberSecond) == totalNumber) {
                                animation!!.end()
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                                vibrator!!.vibrate(1000)

                            }
                        }
                        3 -> {
                            val numberFirst = Integer.parseInt(number1.text.toString())
                            val numberSecond = Integer.parseInt(number2.text.toString())
                            val totalNumber = Integer.parseInt(numberText.text.toString())

                            if ((numberFirst / numberSecond) == totalNumber) {
                                animation!!.end()
                                randomImage = (0..3).random()
                                operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))
                                randomMethod()
                                numberText.text = ""
                            } else {
                                showLongToast("Yanlis")
                                vibrator!!.vibrate(1000)

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

        if (math.equals("Mixed") || operation.equals("mixed")){

            randomImage = (0..3).random()
            operator.setImageDrawable(ContextCompat.getDrawable(this, randOperator[randomImage]))

        }

        if (operation != null){
            animation!!.end()
        } else {

            randomMethod()
            numberText.text = ""
        }
    }

    fun Back(view: View) {
        if (diff != null){
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, DifficultyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}