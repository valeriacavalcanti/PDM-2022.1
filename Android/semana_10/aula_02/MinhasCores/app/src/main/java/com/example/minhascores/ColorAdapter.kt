package com.example.minhascores

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class ColorAdapter(var context: Context, var lista: ArrayList<Int>): BaseAdapter() {

    override fun getCount(): Int {
        return this.lista.size
    }

    override fun getItem(p0: Int): Any {
        return this.lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, p2: ViewGroup?): View {
        val v = if (view == null){
            LayoutInflater.from(this.context).inflate(R.layout.item_lista_layout, p2, false)
        }else {
            view
        }

        val ivCor = v.findViewById<ImageView>(R.id.ivCor)
        val tvCor = v.findViewById<TextView>(R.id.tvCodigoCor)

        //ivCor.setColorFilter(Color.valueOf(this.lista[position]))
        ivCor.setBackgroundColor(Color.RED)
        //ivCor.setColorFilter(Color.BLACK)
        tvCor.text = this.lista[position].toString()

        return v
    }
}