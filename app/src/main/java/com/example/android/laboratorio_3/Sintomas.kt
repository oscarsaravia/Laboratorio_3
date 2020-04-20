package com.example.android.laboratorio_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.laboratorio_3.databinding.ActivitySintomasBinding
import com.example.android.laboratorio_3.databinding.ActivityVirusBinding
import kotlinx.android.synthetic.main.activity_virus.*

class Sintomas : AppCompatActivity() {

    private lateinit var binding: ActivitySintomasBinding
    private var topic = Topic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setTitle("Sintomas")

        //Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sintomas)
        binding.myname = topic
        binding.button2.setOnClickListener{
            regresar()
        }


    }

    //Funcion para hacer toast y volver a la actividad principal
    private fun regresar(){
        binding.apply {
            topic?.coment = editText2.text.toString()
        }
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("comentario", topic.coment)

        }
        startActivity(intent)
        Toast.makeText(this, topic.coment, Toast.LENGTH_SHORT).show()
    }

}
