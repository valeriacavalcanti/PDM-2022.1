package com.example.diadasemana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etDia: EditText
    private lateinit var etMes: EditText
    private lateinit var etAno: EditText
    private lateinit var btVer: Button
    private lateinit var tvDia: TextView
    private lateinit var calendario: Calendario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.calendario = Calendario()

        this.etDia = findViewById(R.id.etDia)
        this.etMes = findViewById(R.id.etMes)
        this.etAno = findViewById(R.id.etAno)
        this.btVer = findViewById(R.id.btVerDiaDaSemana)
        this.tvDia = findViewById(R.id.tvDiaDaSemana)

        this.tvDia.text = this.calendario.diaDaSemana()

//        MÉTODO 1

//        this.btVer.setOnClickListener{
//            val dia = this.etDia.text.toString().toInt()
//            val mes = this.etMes.text.toString().toInt()
//            val ano = this.etAno.text.toString().toInt()
//            this.calendario.setData(dia, mes, ano)
//            this.tvDia.text = this.calendario.diaDaSemana()
//        }

        // MÉTODO 2
        //this.btVer.setOnClickListener{ atualizaDiaDaSemana() }

        // MÉTODO 3
        this.btVer.setOnClickListener(ClickBotao())

        this.btVer.setOnLongClickListener(LongClickBotao())
    }

    // MÉTODO 2
    fun atualizaDiaDaSemana(){
        val dia = this.etDia.text.toString().toInt()
        val mes = this.etMes.text.toString().toInt()
        val ano = this.etAno.text.toString().toInt()
        this.calendario.setData(dia, mes, ano)
        this.tvDia.text = this.calendario.diaDaSemana()
    }

    // MÉTODO 3
    inner class ClickBotao: View.OnClickListener{
        override fun onClick(p0: View?) {
            val dia = this@MainActivity.etDia.text.toString().toInt()
            val mes = this@MainActivity.etMes.text.toString().toInt()
            val ano = this@MainActivity.etAno.text.toString().toInt()
            this@MainActivity.calendario.setData(dia, mes, ano)
            this@MainActivity.tvDia.text = this@MainActivity.calendario.diaDaSemana()

            // val dia2 = etDia.text.toString().toInt()
        }
    }

    inner class LongClickBotao: View.OnLongClickListener{
        override fun onLongClick(p0: View?): Boolean {
            this@MainActivity.tvDia.text = "Dia da Semana"
            return true
        }
    }
}