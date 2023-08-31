package com.curso.android.app.practica.appmiguelmustafa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.appmiguelmustafa.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.curso.android.app.practica.appmiguelmustafa.databinding.ActivityMainBinding
import com.curso.android.app.practica.appmiguelmustafa.model.Comparador


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText1 = findViewById<EditText>(R.id.texto1)
        val editText2 = findViewById<EditText>(R.id.texto2)
        val compareButton = findViewById<Button>(R.id.btnComparar)
        val resultText = findViewById<TextView>(R.id.textoResultado)

        mainViewModel.comparador.observe(this, { comparador ->
            resultText.text = comparador.resultado
        })

        compareButton.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()

            val respuestaBoolean = text1 == text2
            val respuestaString = if (respuestaBoolean) "Los textos son iguales" else "Los textos son distintos"

            val comparador = Comparador(text1, text2, respuestaString)
            mainViewModel.updateComparador(comparador)
        }

    }
}