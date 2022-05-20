package com.example.mybrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btVer: Button
    private lateinit var etEndereco: EditText
    private lateinit var wvConteudo: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btVer = findViewById(R.id.btVer)
        this.etEndereco = findViewById(R.id.etEndereco)
        this.wvConteudo = findViewById(R.id.wvPagina)

        this.btVer.setOnClickListener{ ver() }

        this.wvConteudo.webViewClient = WebViewClient()
        this.wvConteudo.settings.javaScriptEnabled = true

        if (intent.data != null){
            this.wvConteudo.loadUrl(intent.data.toString())
        }
    }

    fun ver(){
        val url = this.etEndereco.text.toString()
        this.wvConteudo.loadUrl(url)
    }
}