package com.example.minhascores

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var etRed: EditText
    private lateinit var etGreen: EditText
    private lateinit var etBlue: EditText
    private lateinit var btAdd: Button
    private lateinit var lvCores: ListView

    private lateinit var lista: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = arrayListOf()

        this.etRed = findViewById(R.id.etRed)
        this.etGreen = findViewById(R.id.etGreen)
        this.etBlue = findViewById(R.id.etBlue)
        this.lvCores = findViewById(R.id.lvCores)

        this.btAdd = findViewById(R.id.btAdd)
        this.btAdd.setOnClickListener{ add() }

        this.lvCores.adapter = ColorAdapter(this, this.lista)
    }

    fun add(){
        val red = this.etRed.text.toString().toInt()
        val green = this.etGreen.text.toString().toInt()
        val blue = this.etBlue.text.toString().toInt()
        this.lista.add(Color.rgb(red, green, blue))
        (this.lvCores.adapter as BaseAdapter).notifyDataSetChanged()
    }
}