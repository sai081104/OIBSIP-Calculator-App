
package com.example.calculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var firstNumber: EditText
    lateinit var secondNumber: EditText
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumber = findViewById(R.id.firstNumber)
        secondNumber = findViewById(R.id.secondNumber)
        resultText = findViewById(R.id.resultText)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val subBtn = findViewById<Button>(R.id.subBtn)
        val mulBtn = findViewById<Button>(R.id.mulBtn)
        val divBtn = findViewById<Button>(R.id.divBtn)

        addBtn.setOnClickListener { calculate('+') }
        subBtn.setOnClickListener { calculate('-') }
        mulBtn.setOnClickListener { calculate('*') }
        divBtn.setOnClickListener { calculate('/') }
    }

    private fun calculate(op: Char) {
        val num1 = firstNumber.text.toString().toDoubleOrNull()
        val num2 = secondNumber.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultText.text = "Please enter valid numbers"
            return
        }

        val result = when (op) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> if (num2 != 0.0) num1 / num2 else "Error: Divide by 0"
            else -> "Invalid"
        }

        resultText.text = "Result: $result"
    }
}
