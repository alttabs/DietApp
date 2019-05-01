package com.example.dietaapp


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declaração de variaveis

    var button: Button? = null
    var button2: Button? = null
    var sexo: Boolean? = null
    var TMB: Double? = null
    var idade: Int? = null
    var peso: Double? = null
    var altura: Int? = null
    var atividade: Int? = null
    var natasha: DoubleArray = doubleArrayOf(1.00, 1.11, 1.25, 1.48)


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //userHeightFirst = findViewById(R.id.etAltura)
        //userWeight = findViewById(R.id.etPeso)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)


        //Find view by id

        var etIdade = findViewById<EditText>(R.id.etIdade)
        var etPeso = findViewById<EditText>(R.id.etPeso)
        var etAltura = findViewById<EditText>(R.id.etAltura)
        var texto = findViewById<TextView>(R.id.textView2)

        //inicializar funções

        verificarRadioSexo()
        verificarRadioAtividade()


        button?.setOnClickListener {

            this.idade = etIdade.getText().toString().toInt()
            this.peso = etPeso.getText().toString().toDouble()
            this.altura = etAltura.getText().toString().toInt()

            //tratar de peso

            if(idade == null){
                idade = 0
            }

            if(peso == null){
                peso = 0.00
            }

            if(altura == null){
                altura = 0
            }



            if(this.sexo == true){

                TMB  = 354 -(idade!! * 6.9  ) + natasha[atividade!!] * (9.3 * peso!!) + (726 * (altura!!/100) )
                texto.setText(TMB.toString())


            } else if(this.sexo == false){

                TMB  = 662 -(idade!! * 9.5  ) + natasha[atividade!!] * (15.9 * peso!!) + (539.6 * (altura!!/100) )
                texto.setText(TMB.toString())

            } else {

                //mensagemErro()
                texto.setText("vacilou")

            }

            }

            button2?.setOnClickListener { startActivity(Intent(this@MainActivity, Dieta1Activity::class.java)) }

        }


        public fun verificarRadioSexo(){

            var x = findViewById<TextView>(R.id.textView3)
            rgSexo.setOnCheckedChangeListener { group, checkedId ->
                run {

                    if (checkedId == R.id.Mulher) {

                        this.sexo = true
                        x.setText("sou muia")

                    } else if (checkedId == R.id.Homem) {

                        this.sexo = false
                        x.setText("sou hom")

                    } else {

                        x.setText("TEu cu")

                    }


                }
            }

        }


        public fun verificarRadioAtividade(){

            rgAtividade.setOnCheckedChangeListener { group, checkedId ->
                run {

                if(checkedId == R.id.rbSedentario){

                    this.atividade = 0

                } else if (checkedId == R.id.rbLeve){

                    this.atividade = 1

                } else if (checkedId == R.id.rbModerado){

                    this.atividade = 2

                } else if (checkedId == R.id.rbIntenso){

                    this.atividade = 3

                } else {

                    //mensagemErro()

                }


            }}

        }


        public fun calcularTMB(altura: Int, peso: Double, idade: Int, atividade: Int){

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



