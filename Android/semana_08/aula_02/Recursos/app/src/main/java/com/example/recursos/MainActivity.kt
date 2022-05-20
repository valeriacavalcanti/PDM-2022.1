package com.example.recursos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btHTML: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btCompartilhar: Button
    private lateinit var btEmail: Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btSMS: Button
    private lateinit var btYoutube: Button
    private lateinit var btFoto: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHTML = findViewById(R.id.btHTML)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btCompartilhar = findViewById(R.id.btCompartilhar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btSMS = findViewById(R.id.btSMS)
        this.btYoutube = findViewById(R.id.btYoutube)
        this.btFoto = findViewById(R.id.btFoto)

        this.btHTML.setOnClickListener { html() }
        this.btDiscar.setOnClickListener { discar() }
        this.btLigar.setOnClickListener { ligar() }
        this.btCompartilhar.setOnClickListener { compartilhar() }
        this.btEmail.setOnClickListener { email() }
        this.btPonto.setOnClickListener { ponto() }
        this.btRota.setOnClickListener { rota() }
        this.btSMS.setOnClickListener { sms() }
        this.btYoutube.setOnClickListener { youtube() }
        this.btFoto.setOnClickListener { foto() }
    }

    fun html(){
        val uri = Uri.parse("http://ifpb.edu.br")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
        }
    }

    fun discar(){
        val uri = Uri.parse("tel:36121392")
        val intent = Intent(Intent.ACTION_DIAL, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
        }
    }

    fun ligar(){
        val uri = Uri.parse("tel:36121392")
        val intent = Intent(Intent.ACTION_CALL, uri)

        val call = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(this, call) == granted){
            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }else{
            Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show()
        }
    }

    fun compartilhar(){

    }

    fun email(){

    }

    fun ponto(){

    }

    fun rota(){

    }

    fun sms(){

    }

    fun youtube(){

    }

    fun foto(){

    }
}