package com.example.diasemana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var calendario: Calendario
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.calendario = Calendario()
        this.texto = findViewById(R.id.tvDia)
        this.texto.text = this.calendario.diaDaSemana()
    }

}