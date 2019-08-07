package com.example.demoloop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            for (i in 1..5) {
                Log.d("ForLoop", "$i")

            }

            var j = 1
            while (j < 6) {
                Log.d("WhileLoop", "$j")
                j++
            }
        }

        button2.setOnClickListener {
            val word = editText.text.toString()
            for(i in word){
                Log.d("ForWord", "$i")
            }
        }
    }
}
