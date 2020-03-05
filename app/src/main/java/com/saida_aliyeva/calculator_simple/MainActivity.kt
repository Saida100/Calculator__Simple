package com.saida_aliyeva.calculator_simple

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.round
import java.math.BigDecimal
import java.math.RoundingMode
import android.text.style.ForegroundColorSpan as ForegroundColorSpan1

class MainActivity : AppCompatActivity() {
    lateinit var myList: List<String>
    var symbol: String = ""
    var text:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        clear.setOnClickListener {
            result.text = ""
            symbol = ""
        }
        one.setOnClickListener {
            text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(one.text.toString())
            } else {
                showToastMessage()
            }
        }
        two.setOnClickListener {
            text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(two.text.toString())
            } else {
                showToastMessage()
            }
        }
        three.setOnClickListener {
            text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(three.text.toString())
            } else {
                showToastMessage()
            }
        }
        four.setOnClickListener {
             text = result.text.toString()

            if (checkLengthText(text)) {
                addNumberToEditText(four.text.toString())
            } else {
                showToastMessage()
            }
        }
        five.setOnClickListener {
             text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(five.text.toString())
            } else {
                showToastMessage()
            }
        }
        six.setOnClickListener {
             text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(six.text.toString())
            } else {
                showToastMessage()
            }
        }
        seven.setOnClickListener {
             text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(seven.text.toString())
            } else {
                showToastMessage()
            }
        }
        eight.setOnClickListener {
             text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(eight.text.toString())
            } else {
                showToastMessage()
            }
        }
        nine.setOnClickListener {
             text = result.text.toString()
            if (checkLengthText(text)) {
                addNumberToEditText(nine.text.toString())
            } else {
                showToastMessage()
            }
        }
        zero.setOnClickListener {
             text = result.text.toString()
            if (text.isEmpty() || (text.isNotEmpty() && !text.equals("0")
                        && !text.endsWith("+0")
                        && !text.endsWith("-0")
                        && !text.endsWith("*0")
                        && !text.endsWith("/0")
                        && !text.endsWith("/")
                        && !text.contains("=")
                        && checkLengthText(text))
            ) {
                result.append("0")
            }
        }


        plus.setOnClickListener {
             text = result.text.toString()
            addSign(text, "+")
            //   symbol = "+"
        }
        minus.setOnClickListener {
             text = result.text.toString()
            addSign(text, "-")
            //   symbol = "-"

        }
        multiple.setOnClickListener {
             text = result.text.toString()
            addSign(text, "*")
            //   symbol = "*"

        }
        divide.setOnClickListener {
            text = result.text.toString()
            addSign(text, "/")
            //   symbol = "/"


        }
        equal.setOnClickListener {
             text = result.text.toString()
            if (text.isNotEmpty() && !text.endsWith("+")
                && !text.endsWith("-")
                && !text.endsWith("*")
                && !text.endsWith("/")
                && !text.endsWith("=")
                && !text.endsWith(".")
                && !text.contains("=")
                && (text.contains("+") || text.contains("-") || text.contains("*") || text.contains(
                    "/"
                ))
            ) {
                result.append("=")
                calculate()

            }

        }
        backSpace.setOnClickListener {
             text = result.text.toString()

            if (text.length > 0) {
                if(text.contains("=")){
                    changeSubStringColor(text.substring(0, text.length - 1))
                } else{
                    result.text = text.substring(0, text.length - 1)
                }

            } else {
                symbol = ""
            }


        }
        point.setOnClickListener {
             text = result.text.toString()
            if (text.isNotEmpty() && !text.contains("=") && checkLengthText(text)) {
                if (!text.contains(".")) {
                    if (!text.endsWith("+")
                        && !text.endsWith("-")
                        && !text.endsWith("*")
                        && !text.endsWith("/")
                        && !text.endsWith("=")
                    ) {
                        result.append(".")
                    }
                } else if ((text.contains("+") && !text.endsWith("+") && !(text.substring(
                        text.indexOf(
                            "+"
                        ), text.length
                    ).contains(".")))
                    || (text.contains("-") && !text.endsWith("-") && !(text.substring(
                        text.indexOf("-"),
                        text.length
                    ).contains(".")))
                    || (text.contains("*") && !text.endsWith("*") && !(text.substring(
                        text.indexOf("*"),
                        text.length
                    ).contains(".")))
                    || (text.contains("/") && !text.endsWith("/") && !(text.substring(
                        text.indexOf("/"),
                        text.length
                    ).contains(".")))
                ) {
                    result.append(".")

                }
            }

        }

    }

    fun addSign(text: String, symbol1: String) {
        if (text.isNotEmpty() && !text.contains("+")
            && !text.contains("-")
            && !text.contains("*")
            && !text.contains("/")
            && !text.contains("=")
            && !text.endsWith(".")
        ) {
            result.append(symbol1)
            symbol = symbol1

        }

    }

    fun splitString(text: String): List<String> {
        val parts: List<String>
        parts = text.split("+", "-", "*", "/")
        return parts
    }


    fun addNumberToEditText(nameButton: String) {
        text = result.text.toString()
        if (text.isEmpty() || (text.length > 0 && !text.contains("="))) {
            result.append(nameButton)

        }

    }

    fun calculate() {
        val text = result.text.toString()
        var res: Double = 0.0
        var decimal: BigDecimal
        myList = splitString(text.substring(0, text.length - 1))
        when (symbol) {
            "+" -> {
                res = myList[0].toDouble() + myList[1].toDouble()
            }
            "-" -> {
                res = myList[0].toDouble() - myList[1].toDouble()
            }
            "*" -> {
                res = myList[0].toDouble() * myList[1].toDouble()
            }
            "/" -> {
                res = myList[0].toDouble() / myList[1].toDouble()
            }

        }
        decimal = BigDecimal(res).setScale(2, RoundingMode.HALF_EVEN)
        result.append(decimal.toString())
        changeSubStringColor(result.text.toString())

    }

    fun checkLengthText(text: String): Boolean {

            if((symbol == "" && text.length <= 14) || (symbol != "" && text.substring(
                    text.indexOf(symbol)
                ).length-1 <= 14)){
                return true

            }else{
                return false
            }

    }

    fun showToastMessage() {
        if(!result.text.toString().contains("=")){
            Toast.makeText(this, "Maximum number is digit (15) exceeded", Toast.LENGTH_SHORT).show()

        }
    }

    fun changeSubStringColor(text: String) {
        var ss: SpannableString = SpannableString(text)
        var red: ForegroundColorSpan1
        red = android.text.style.ForegroundColorSpan(Color.RED)
        ss.setSpan(red, text.indexOf("=") + 1, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        result.text = ss
    }
}
