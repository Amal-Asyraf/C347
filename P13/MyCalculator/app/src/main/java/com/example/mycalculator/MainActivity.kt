package com.example.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var result = 0.0
    var first = 0.0
    var second = 0.0
    var operand = '+'
    var display = "0"
    var index = 0
    var justCleared = false
    var isDecimal = false
    var conDecimal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = "0"

    }

    fun btnOnClick(view: View) {
        var msg = ""
        val btnSelected = view as Button

        when (btnSelected.id) {
            button1.id -> msg = "1"
            button2.id -> msg = "2"
            button3.id -> msg = "3"
            button4.id -> msg = "4"
            button5.id -> msg = "5"
            button6.id -> msg = "6"
            button7.id -> msg = "7"
            button8.id -> msg = "8"
            button9.id -> msg = "9"
            button0.id -> msg = "0"
        }



        justCleared = false
        if (isDecimal) {
            var integer = 0

            if(conDecimal) {
                display = "$display$msg"
            }else{
                try {
                    integer = display.toInt()
                }
                catch (e: java.lang.IllegalStateException) {
                    conDecimal = true
                }
                display = "$integer.$msg"
                conDecimal = true
            }

        } else{
            display = "$display$msg"
        }
        val number = display.toDouble()
        Log.d("First Display", "$number")
        result = number
        tvResult.text = "$number"
    }

    fun btnOnClickClear(view: View){
        display = ""
        result = 0.0
        index = 0
        first = 0.0
        second = 0.0
        tvResult.text = "0"
        justCleared = false
        isDecimal = false
        conDecimal = false
    }
    fun btnOnClickDot(view: View){
        var check = false

        for(i in display){
            if(i=='.'){
                check = true
            }
        }

        if(!check) {
            val number = display.toDouble()
            Log.d("First Display", "$number")
            tvResult.text = "$number"
        }

        isDecimal = true
    }
    fun btnOnClickOper(view: View){
        if(justCleared){
            return
        }
        var msg = 'x'
        Log.d("First Operand  Result", "$operand")

        val btnSelected = view as Button
        when(btnSelected.id){
            buttonDivide.id -> msg = '/'
            buttonPlus.id -> msg = '+'
            buttonMinus.id -> msg = '-'
            buttonTimes.id -> msg = '*'

        }

            if(display == "") {
                display = "0"
            }
            if(index == 0) {
                first = display.toDouble()
                display = ""
                operand = msg
                tvResult.text = ""
                index = 1
                Log.d("First Input", "$first")
            }else{
                second = display.toDouble()
                Log.d("First Result MSG", "$msg")
                Log.d("First Before Result", "$first")
                if(operand == '+') {
                    result = first + second
                    Log.d("First Plus", "$first")

                }else if(operand == '-') {
                    result = first - second
                    Log.d("First Minus", "$first")

                }else if(operand == '/') {
                    result = first / second
                    Log.d("First Divide", "$first")

                }else if(operand == '*'){
                    result = first * second
                    Log.d("First Times", "$first")
                }
                first = result
                Log.d("First Result", "$first")
                operand = msg

                display = ""
                tvResult.text = ""
            }
            Log.d("First After  Result", "$operand")


        }

    fun btnClickEquals(view: View){

            second = display.toDouble()
            Log.d("First Operand  Result", "$operand")

            Log.d("First Before Result", "$first")
            if(operand == '+') {
                result = first + second
                Log.d("First Plus Result", "$first")

            }else if(operand == '-') {
                result = first - second
                Log.d("First Minus Result", "$first")

            }else if(operand == '/') {
                result = first / second
                Log.d("First Divide Result", "$first")

            }else if (operand == '*'){
                result = first * second
                Log.d("First Times Result", "$first")

            }
            Log.d("First Equals Result", "$first")
            tvResult.text = "$result"
        display = "$result"
        operand = 'x'
        first = result
        conDecimal = true
        }
    }


