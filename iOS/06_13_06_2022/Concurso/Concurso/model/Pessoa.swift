//
//  Pessoa.swift
//  Concurso
//
//  Created by Valéria Cavalcanti on 13/06/22.
//

import Foundation

class Pessoa: NSObject, Identifiable, ObservableObject{
    var nome: String
    var curso: String
    @Published var votos: Int
    
    override var description: String{
        return "\(nome) - \(votos)"
    }
    
    init(nome: String, curso: String){
        self.nome = nome
        self.curso = curso
        self.votos = 0
    }
    
    func inicial_curso() -> String {
        switch(self.curso){
            case "CSTSI": return "s.circle.fill"
            case "CSTRC": return "r.circle.fill"
            case "PPGTI": return "m.circle.fill"
            case "CTIN": return "i.circle.fill"
            default:
                return "e.circle.fill"
        }
    }
}
