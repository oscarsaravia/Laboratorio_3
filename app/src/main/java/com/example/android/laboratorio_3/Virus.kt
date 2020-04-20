package com.example.android.laboratorio_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.laboratorio_3.databinding.ActivityMainBinding
import com.example.android.laboratorio_3.databinding.ActivityVirusBinding
import kotlinx.android.synthetic.main.activity_virus.*

class Virus : AppCompatActivity() {

    private lateinit var binding: ActivityVirusBinding
    private var topic = Topic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setTitle("Acerca del virus")
        //Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_virus)
        binding.myname = topic
        binding.button.setOnClickListener{
            comentar()
        }



    }

    //Funcion para hacer toast y volver a la actividad principal
    private fun comentar(){
        binding.apply {
            topic?.coment = editText.text.toString()
        }
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("comentario", topic.coment)
        }
        startActivity(intent)
        Toast.makeText(this, topic.coment, Toast.LENGTH_SHORT).show()
    }

}
