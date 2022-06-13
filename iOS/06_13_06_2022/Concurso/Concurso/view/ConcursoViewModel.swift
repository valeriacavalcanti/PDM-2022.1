//
//  ConcursoViewModel.swift
//  Concurso
//
//  Created by Valéria Cavalcanti on 13/06/22.
//

import Foundation

class ConcursoViewModel: ObservableObject{
    @Published var lista:[Pessoa]
    
    init(){
        self.lista = []
    }
    
    func getAll() -> [Pessoa] {
        return self.lista
    }
    
    func getAll(curso: String) -> [Pessoa]{
        return self.lista.filter { pessoa in
            pessoa.curso == curso
        }
    }
}
