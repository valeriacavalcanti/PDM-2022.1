package com.example.jogoforca

class Forca (var palavra: String, var dica: String) {
    val letrasUsadas: Set<Char>
    var tentativas: Int
    var erros: Int
    val layout: List<Char>

    init {
        this.letrasUsadas = linkedSetOf()
        this.tentativas = 4
        this.erros = 0
        this.layout = arrayListOf()
    }

    fun jogar(letra: Char): Boolean{
        // verificar se o jogo está ativo
            // verificar se a letra é "nova", ou seja, não informada anteriormente
                // registrar a letra no banco de letras jogadas
                // verificar se faz parte da palavra secreta
                    // atualizar o layout
                    // registrar pontuação
                // else
                    // registrar o erro
            // else
                // informar que a tentativa não é válida
        // else
            // informar que o jogo já encerrou
        return true
    }

    fun atualizaLayout(letra: Char){

    }

    fun status(){

    }
}