package com.example.diasemana

import java.util.*

class Calendario {
    private var data: Calendar

    init {
        this.data = Calendar.getInstance()
    }

    fun diaDaSemana(): String{
        val dias = arrayListOf("DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SÁBADO")
        val dia = this.data.get(Calendar.DAY_OF_WEEK)
        return dias[dia - 1]
    }
}