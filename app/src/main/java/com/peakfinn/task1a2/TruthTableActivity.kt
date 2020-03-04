package com.peakfinn.task1a2

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_truth_table.*

class TruthTableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truth_table)

        btnSubmit.setOnClickListener {
            verifyAnswers()
        }
    }

    private fun verifyAnswers() {
        val correctAmount = arrayOf("T", "F", "F", "F").filterIndexed { index, correctAnswer ->
            // get ID (generated under the hood) from name (inputRow1, inputRow2, etc...)
            val inputId = resources.getIdentifier("inputRow${index + 1}", "id", packageName)
            // Get the input element by the ID we found, and compare it's text
            findViewById<EditText>(inputId).text.toString().equals(correctAnswer, true)
        }.count()
        Toast.makeText(applicationContext, getString(R.string.result, correctAmount), Toast.LENGTH_SHORT).show()
    }
}
