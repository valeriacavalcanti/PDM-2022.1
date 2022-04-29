package br.eti.valeria.friends

import java.io.Serializable

class Amigo(var nome: String, var email: String): Serializable{
    override fun toString(): String {
        return nome
    }
}