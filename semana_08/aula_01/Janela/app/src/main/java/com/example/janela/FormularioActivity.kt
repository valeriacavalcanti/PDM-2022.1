package com.example.janela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FormularioActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        Log.i("APP_JANELA", "Formulário - OnCreate")

        this.etNome = findViewById(R.id.etFormNome)
        this.etIdade = findViewById(R.id.etFormIdade)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        if (intent.hasExtra("NOME") && intent.hasExtra("IDADE")){
            val nome = intent.getStringExtra("NOME")
            val idade = intent.getStringExtra("IDADE")
            this.etNome.setText(nome)
            this.etIdade.setText(idade)
        }

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ cancelar() }
    }

    fun salvar(){
        val nome = this.etNome.text.toString()
        val idade = this.etIdade.text.toString()
        val intent = Intent().apply {
            putExtra("NOME_ALTERADO", nome)
            putExtra("IDADE_ALTERADA", idade)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    fun cancelar(){
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_JANELA", "Formulário - OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_JANELA", "Formulário - OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_JANELA", "Formulário - OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_JANELA", "Formulário - OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_JANELA", "Formulário - OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_JANELA", "Formulário - OnDestroy")
    }
}