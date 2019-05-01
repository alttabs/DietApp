package com.example.dietaapp


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declaração de variaveis

    var userHeightFirst: EditText? = null
    var userHeightSecond: EditText? = null
    var userWeight: EditText? = null
    var button: Button? = null
    var display: TextView? = null
    var sexo: Boolean? = null
    var TMB: Double? = null
    var idade: Int? = null
    var peso: Double? = null
    var altura: Double? = null
    var atividade: Int? = null
    var natasha: DoubleArray = doubleArrayOf(1.0, 1.11, 1.25, 1.48)


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userHeightFirst = findViewById(R.id.etAltura)
        userWeight = findViewById(R.id.etPeso)
        button = findViewById(R.id.button)


        //Find view by id

        var etIdade = findViewById<EditText>(R.id.etIdade)
        var etPeso = findViewById<EditText>(R.id.etPeso)
        var etAltura = findViewById<EditText>(R.id.etAltura)


        //

        idade = etIdade.toString().toInt()
        this.peso = etPeso.toString().toDoubleOrNull()
        this.altura = etAltura.toString().toDoubleOrNull()



        /*
        display?.text = "\tInserir Texto Aqui"
        info4.text = "Abaixo do peso     \t Menos que 18.5"
        info5.text = "Normal          \t\t\t\t\t 18.5 à 24.9"
        info6.text = "Acima do peso      \t 25.0 à 29.9"
        info7.text = "Obesidade classe |    \t 30.5 à 34.9"
        info8.text = "Obesidade classe ||  \t 35.0 à 39.9"
        info9.text = "Obesidade classe ||  \t Maior que 40"
//end of the lame disply part
*/

        verificarRadioSexo()
        verificarRadioAtividade()
        //calcularTMB(altura!!, peso!!, idade!!, atividade!!)


        button?.setOnClickListener {startActivity(Intent(this@MainActivity, Dieta1Activity::class.java))

            calcularTMB(altura!!, peso!!, idade!!, atividade!!)

            }
        }


        public fun verificarRadioSexo(){

            rgSexo.setOnCheckedChangeListener { group, checkedId ->  {

                if(checkedId == R.id.Mulher){

                    this.sexo = true

                } else if (checkedId == R.id.Homem){

                    this.sexo = false

                }


            }}

        }


        public fun verificarRadioAtividade(){

            rgAtividade.setOnCheckedChangeListener { group, checkedId ->  {

                if(checkedId == R.id.rbSedentario){

                    this.atividade = checkedId

                } else if (checkedId == R.id.rbLeve){

                    this.atividade = checkedId

                } else if (checkedId == R.id.rbModerado){

                    this.atividade = checkedId

                } else if (checkedId == R.id.rbIntenso){

                    this.atividade = checkedId

                } else {

                    //mensagemErro()

                }


            }}

        }


        public fun calcularTMB(altura: Double, peso: Double, idade: Int, atividade: Int){

            val texto = findViewById<TextView>(R.id.textView3)

            if(this.sexo == true){

                TMB  = 66.5 -(idade * 9.5) + (natasha[atividade] * (15.9 * peso)) + (539.6 * altura )
                texto.setText(TMB.toString())


            } else if(this.sexo == false){

                TMB  = 662 -(idade * 9.5) + (natasha[atividade] * (15.9 * peso)) + (539.6 * altura )
                texto.setText(TMB.toString())

            } else {

                //mensagemErro()

            }

        }




        public fun mensagemErro(){



        }


    }



