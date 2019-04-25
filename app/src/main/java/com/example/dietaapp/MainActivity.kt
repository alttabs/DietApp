package com.example.dietaapp


import android.support.v7.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    companion object {

        fun calculateBMI(weight: Double, height: Double): Pair<String, Int> {
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.HALF_UP

            val bmi = weight / (height * height)
            return Pair("BMI\n" + df.format(bmi), bmi.toInt())
        }

        fun getCategoryIdentifier(bmiVal: Int): Int {
            val categoryColorCode: Int

            when (bmiVal) {
                in 0..18 -> {
                    categoryColorCode = R.color.blue
                }
                in 19..24 -> {
                    categoryColorCode = R.color.green
                }
                in 25..29 -> {
                    categoryColorCode = R.color.yellow
                }
                in 30..39 -> {
                    categoryColorCode = R.color.orange
                }
                else -> {
                    categoryColorCode = R.color.red
                }
            }
            return categoryColorCode
        }
    }

}
