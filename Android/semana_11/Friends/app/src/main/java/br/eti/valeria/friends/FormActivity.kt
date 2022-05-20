package br.eti.valeria.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etEmail: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.etEmail = findViewById(R.id.etFormEmail)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ cancelar() }
    }

    fun salvar(){
        val nome = this.etNome.text.toString()
        val email = this.etEmail.text.toString()
        val amigo = Amigo(nome, email)
        val intent = Intent().apply {
            putExtra("AMIGO_NOVO", amigo)
        }
        setResult(RESULT_OK, intent)
        this.finish()
    }

    fun cancelar(){
        this.finish()
    }
}