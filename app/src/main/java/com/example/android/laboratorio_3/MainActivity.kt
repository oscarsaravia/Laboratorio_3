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


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var topic = Topic("OSCAR")
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myname = topic



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

    private fun ocultar(view: View){
        contador += 1
        binding.apply {
            topic?.name = editText5.text.toString()
            topic?.edad = editText6.text.toString().toInt()
            invalidateAll()
            if(contador % 2 == 0){
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.VISIBLE
                textView19.visibility = View.VISIBLE
                textView18.text = "Nombre"
            }
            else{
                editText5.visibility = View.GONE
                editText6.visibility = View.GONE
                textView19.visibility = View.GONE

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
