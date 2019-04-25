package com.example.dietaapp


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var userHeightFirst: EditText? = null
    var userHeightSecond: EditText? = null
    var userWeight: EditText? = null
    var button: Button? = null
    var display: TextView? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userHeightFirst = findViewById(R.id.editText1)
        userHeightSecond = findViewById(R.id.editText2)
        userWeight = findViewById(R.id.editText3)
        button = findViewById(R.id.button)
        display = findViewById(R.id.textView2)

        //start of the lame display part+

        var info4: TextView = findViewById(R.id.textView4)
        var info5: TextView = findViewById(R.id.textView5)
        var info6: TextView = findViewById(R.id.textView6)
        var info7: TextView = findViewById(R.id.textView7)
        var info8: TextView = findViewById(R.id.textView8)
        var info9: TextView = findViewById(R.id.textView9)

        info4.setTextColor(Color.BLUE)
        info5.setTextColor(Color.GREEN)
        info6.setTextColor(Color.RED)
        info7.setTextColor(Color.GREEN)
        info8.setTextColor(Color.RED)
        info9.setTextColor(Color.BLUE)
        display?.setTextColor(Color.GREEN)
        //display?.setTextSize(30)

        display?.text = "\tPLEASE ENTER THE ABOVE DETAILS"
        info4.text = "Underweight     \t less than 18.5"
        info5.text = "Normal          \t 18.5 to 24.9"
        info6.text = "Overweight      \t t25.0 to 29.9"
        info7.text = "Obese Clas |    \t 30.5 to 34.9"
        info8.text = "Obese Class ||  \t 35.0 to 39.9"
        info9.text = "Obese Class ||  \t greater than 40"
//end of the lame disply part


        button?.setOnClickListener {startActivity(Intent(this@MainActivity, Dieta1Activity::class.java))
            }
        }


    }



