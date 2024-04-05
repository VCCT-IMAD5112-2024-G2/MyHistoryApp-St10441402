package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    enum class HistoricalFigure(val age: Int, val description: String) {
        FIGURE_1(55, "Christopher Columbus who was an Italian explorer who died in the year 1506"),
        FIGURE_2(25, "Tupac Shakur who was an influential American rapper who died in the year 1996"),
        FIGURE_3(67, "Leonardo Da Vinci who was an Italian polymath during the High Renaissance. He died in the year 1519"),
        FIGURE_4(76, "Albert Einstein who was a German-born theoretical physicist who died in the year 1955"),
        FIGURE_5(52, "William Shakespeare who was an English playwright, poet, and actor who died in the year 1616"),
        FIGURE_6(95, "Nelson Mandela who was an anti-apartheid activist and South Africa's first black president after the democratic election. He died in the year 2013"),
        FIGURE_7(42, "Kobe Bryant who was an American basketball player who played in the NBA for 20 years for the Los Angeles Lakers. He died in the year 2020"),
        FIGURE_8(35,"Wolfgang Mozart who was a prolific and influential composer of the classical period. He died in the year 1791"),
        FIGURE_9(77,"Galileo Galilei who was an Italian astronomer, physicist, and engineer who died in the year 1642"),
        FIGURE_10(32,"Bruce Lee who was a Hong-Kong American martial artist and actor who died in the year 1973"),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtAgeNumber = findViewById<EditText>(R.id.edtAge)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnGenerate?.setOnClickListener {
            val edtAge = edtAgeNumber.text.toString().toIntOrNull()

            if (edtAge != null && edtAge in 20..100) {
                val events = when (edtAge) {
                    in HistoricalFigure.values().map { it.age } -> {
                        val event = HistoricalFigure.values().find { it.age == edtAge }
                        listOf("Your age is the same as historical figure  ${event?.description ?: "event"}")
                    }
                    in HistoricalFigure.values().map { it.age - 1 } -> {
                        val event = HistoricalFigure.values().find { it.age == edtAge + 1 }
                        listOf("Your age is one year before the historical figure  ${event?.description ?: "event"}")
                    }
                    in HistoricalFigure.values().map { it.age + 1 } -> {
                        val event = HistoricalFigure.values().find { it.age == edtAge - 1 }
                        listOf("Your age is one year after the historical figure ${event?.description ?: "event"}")
                    }
                    else -> listOf("No historical figure found $edtAge.")
                }
                txtResult.text = events.joinToString("\n")
            } else {
                txtResult.text = "No event has been found from the input of your birth years."
            }
        }

        btnClear?.setOnClickListener {
            edtAgeNumber.text.clear()
            txtResult.text = ""
        }
    }
}









