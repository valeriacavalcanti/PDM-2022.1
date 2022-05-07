package com.example.salvadordepessoas

import android.content.ContentValues
import android.content.Context

class PessoaDAO (var context: Context) {
    var banco: BancoHelper

    init {
        this.banco = BancoHelper(this.context)
    }

    fun insert(pessoa: Pessoa){
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        this.banco.writableDatabase.insert("pessoa", null, cv)
    }

    fun select(): ArrayList<Pessoa>{
        var lista = arrayListOf<Pessoa>()
        val colunas = arrayOf("id", "nome", "idade")
        val cursor = this.banco.readableDatabase.query("pessoa", colunas, null, null, null, null, null)
        cursor.moveToFirst()
        for (i in 1 .. cursor.count){
            var id = cursor.getInt(colunas.indexOf("id"))
            var nome = cursor.getString(colunas.indexOf("nome"))
            var idade = cursor.getInt(colunas.indexOf("idade"))
            lista.add(Pessoa(id, nome, idade))
            cursor.moveToNext()
        }

        return lista
    }

    fun find(id: Int): Pessoa?{
        return null
    }

    fun count(): Int{
        return 0
    }

    fun delete(id: Int){

    }

    fun update(pessoa: Pessoa){

    }
}