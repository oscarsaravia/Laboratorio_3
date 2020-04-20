package com.example.android.laboratorio_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.android.laboratorio_3.databinding.ActivityMainBinding
import android.widget.EditText
import android.widget.Toast
/*
Universidad del Valle de Guatemala
Programacion de plataformas móviles y juegos
Autor: Oscar René Saravia Donis
Carné 19322
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var topic = Topic("OSCAR")
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Implementacion de binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myname = topic


        //Acciones de los botones
        binding.imageButton4.setOnClickListener {
            ocultar(it)
        }
        binding.button13.setOnClickListener{
            virus()
        }
        binding.button16.setOnClickListener{
            sintomas()
        }
        binding.button17.setOnClickListener{
            indicaciones()
        }



    }

    //Funcion para ocultar los edit text y los text views
    private fun ocultar(view: View){
        contador += 1 //contadora para controlar la aparicion de los textos
        binding.apply {
            topic?.name = editText5.text.toString()
            topic?.edad = editText6.text.toString().toInt()
            invalidateAll()
            if(contador % 2 == 0){ // Si el contador es par hacer los textos visibles
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.VISIBLE
                textView19.visibility = View.VISIBLE
                textView18.text = "Nombre"
            }
            else{ //Si es impar quitar los textos
                editText5.visibility = View.GONE
                editText6.visibility = View.GONE
                textView19.visibility = View.GONE

                // Verificar en que rango de edad se encuentra el usuario
                if (topic.edad in 0..40){
                    textView18.setText(topic.name + " por tu rango de edad no te encuentras en riesgo si contraes el virus")
                }
                else if(topic.edad in 41..70){
                    textView18.setText(topic.name + " por tu rango de edad tienes un grado considerable de riesgo si contraes el virus")
                }
                else if(topic.edad >= 71){
                    textView18.setText(topic.name + " por tu rango de edad estás en el grupo de mayor riesgo si contraes el virus")
                }
                else{
                    textView18.setText("Por favor ingresar los datos para obtener mayor informacion sobre tu riesgo ante el virus")
                }
            }



        }
    }

    // Funciones para redirigir a las actividades correspondientes

    private fun sintomas(){
        val intent = Intent(this, Sintomas::class.java).apply {
        }
        startActivity(intent)
    }

    private fun virus(){
        val intent = Intent(this, Virus::class.java).apply {
        }
        startActivity(intent)
    }

    private fun indicaciones(){
        val intent = Intent(this, Indicaciones::class.java).apply {
        }
        startActivity(intent)
    }


}
