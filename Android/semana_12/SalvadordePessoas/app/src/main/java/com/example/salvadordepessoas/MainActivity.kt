package com.example.salvadordepessoas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btListar: Button
    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = PessoaDAO(this)

        this.etNome = findViewById(R.id.etNome)
        this.etIdade = findViewById(R.id.etIdade)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btListar = findViewById(R.id.btListar)

        this.btSalvar.setOnClickListener{ salvar() }
        this.btListar.setOnClickListener{ listar() }
    }

    fun salvar(){
        val nome = this.etNome.text.toString()
        val idade = this.etIdade.text.toString().toInt()
        val pessoa = Pessoa(nome, idade)
        this.dao.insert(pessoa)
        Toast.makeText(this, "Pessoa ${pessoa.nome} salva", Toast.LENGTH_LONG).show()
    }

    fun listar(){
        Log.i("APP_SALVADOR", this.dao.select().toString())
    }
}