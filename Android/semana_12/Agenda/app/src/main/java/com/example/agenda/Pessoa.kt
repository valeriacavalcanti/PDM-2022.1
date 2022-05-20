package com.example.agenda

import java.io.Serializable

class Pessoa(var nome: String, var idade: Int): Serializable{
    override fun toString(): String {
        return this.nome
    }
}