package com.example.listagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvTodos: ListView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var lista: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = arrayListOf()

        this.lvTodos = findViewById(R.id.lvTodos)
        this.fabAdd = findViewById(R.id.fabAdd)

        this.lvTodos.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.lista)

        this.fabAdd.setOnClickListener{ add() }
        this.lvTodos.setOnItemClickListener( ClickItemLista() )
        this.lvTodos.setOnItemLongClickListener( LongClickItemLista() )
    }

    fun add(){
        val item = "Elemento ${lista.size + 1}"
        // Via adapter
        (this.lvTodos.adapter as ArrayAdapter<String>).add(item)
        Log.i("APP_LISTAGEM", this.lista.toString())
    }

    inner class ClickItemLista: AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            val item = this@MainActivity.lista[p2]
            Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
        }
    }

    inner class LongClickItemLista: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean {
            this@MainActivity.lista.removeAt(p2)
            (this@MainActivity.lvTodos.adapter as ArrayAdapter<String>).notifyDataSetChanged()
            return true
        }
    }
}