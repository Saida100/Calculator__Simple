package com.saida_aliyeva.calculator_simple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear.setOnClickListener {
            result.text = "";
        }
        one.setOnClickListener {
            addNumberToEditText(one.text.toString())
        }
        two.setOnClickListener {
            addNumberToEditText(two.text.toString())
        }
        three.setOnClickListener {
            addNumberToEditText(three.text.toString())
        }
        four.setOnClickListener {
            addNumberToEditText(four.text.toString())
        }
        five.setOnClickListener {
            addNumberToEditText(five.text.toString())
        }
        six.setOnClickListener {
            addNumberToEditText(six.text.toString())
        }
        seven.setOnClickListener {
            addNumberToEditText(seven.text.toString())
        }
        eight.setOnClickListener {
            addNumberToEditText(eight.text.toString())
        }
        nine.setOnClickListener {
            addNumberToEditText(nine.text.toString())
        }
        zero.setOnClickListener {
            var text = result.text.trim()
            Log.e("Saida",text.toString())
                    if (text.isEmpty() ||

                         (!text.equals("0")
                        && (!text.endsWith("+0")
                        && !text.endsWith("-0")
                        && !text.endsWith("*0")
                        && !text.endsWith("/0")
                        && !text.endsWith("/")
                        && !text.contains("=")))
            ) {
                result.append("0")
            }
        }


        plus.setOnClickListener {
        }
        minus.setOnClickListener {
        }
        multiple.setOnClickListener {
        }
        divide.setOnClickListener {
        }
    }


    fun addNumberToEditText(nameButton: String) {
        val text = result.text
        if (text.isEmpty() || (text.length > 0 && !text.contains("="))) {
            result.append(nameButton)

        }

    }
}
