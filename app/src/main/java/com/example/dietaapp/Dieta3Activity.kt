package com.example.dietaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_dieta3.*

class Dieta3Activity : AppCompatActivity() {

    //Inicializar variaveis

    var divisor: Int = 1
    var resul: Double = 0.00
    var resulfrango: Double = 0.00
    var resularroz: Double = 0.00
    var resulpasta: Double = 0.00



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dieta3)

        //Inicializar variaveis xml

        /*var grupo = findViewById<RadioGroup>(R.id.rgRefeicao)
        var refeicao3 = findViewById<RadioButton>(R.id.rbRefeicao3)
        var refeicao4 = findViewById<RadioButton>(R.id.rbRefeicao4)
        var refeicao5 = findViewById<RadioButton>(R.id.rbRefeicao5)
        var refeicao6 = findViewById<RadioButton>(R.id.rbRefeicao6)*/
        var frango = findViewById<TextView>(R.id.frango)
        var arroz = findViewById<TextView>(R.id.arroz)
        var pasta = findViewById<TextView>(R.id.pasta)
        var botao = findViewById<Button>(R.id.buttonCalcular)

        var valor = findViewById<TextView>(R.id.EERvalor)

        /*var bolha: Bundle? = null
        bolha = intent.getBundleExtra("eer")*/

        var ss: String = intent.getStringExtra("eer")

        valor.setText(ss)

        verificarRadio()

        botao?.setOnClickListener {

            if(divisor != 1){

                resul =  ss.toDouble()/divisor
                resulpasta = resul*0.2
                resularroz = resul*0.4
                resulfrango = resul*0.4

                resularroz = (resularroz*100)/130
                resulpasta = (resulpasta*100)/588
                resulfrango = (resulfrango*100)/239

                resul

                frango.setText(resulfrango.toString())
                pasta.setText(resulpasta.toString())
                arroz.setText(resularroz.toString())

            } else {

                mensagemErro("Por favor, selecione a quantidade de refeições por dia.")

            }

        }



    }


    public fun verificarRadio(){

        rgRefeicao.setOnCheckedChangeListener { group, checkedId ->

            run {

                if (checkedId == R.id.rbRefeicao3){

                    divisor = 3

                } else if (checkedId == R.id.rbRefeicao4){

                    divisor = 4

                } else if (checkedId == R.id.rbRefeicao5){

                    divisor = 5

                } else if (checkedId == R.id.rbRefeicao6){

                    divisor = 6

                }




            }

        }

    }

    public fun mensagemErro(mensagem: String ){

        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()

    }



}
