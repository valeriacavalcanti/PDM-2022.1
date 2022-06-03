//
//  AgendaViewModel.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 03/06/22.
//

import Foundation

class AgendaViewModel: ObservableObject{
    @Published var lista: [Pessoa]
    
    init(){
        self.lista = []
    }
}
