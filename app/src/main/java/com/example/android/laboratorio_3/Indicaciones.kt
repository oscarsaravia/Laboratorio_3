package com.example.android.laboratorio_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.laboratorio_3.databinding.ActivityIndicacionesBinding
import com.example.android.laboratorio_3.databinding.ActivityVirusBinding

class Indicaciones : AppCompatActivity() {

    private lateinit var binding: ActivityIndicacionesBinding
    private var topic = Topic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indicaciones)
        this.setTitle("Indicaciones")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_indicaciones)
        binding.myname = topic
        binding.button3.setOnClickListener{
            comentar()
        }
    }

    private fun comentar(){
        binding.apply {
            topic?.coment = editText3.text.toString()
        }
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("comentario", topic.coment)
        }
        startActivity(intent)
        Toast.makeText(this, topic.coment, Toast.LENGTH_SHORT).show()
    }
}
