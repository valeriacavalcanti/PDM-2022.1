//
//  ContadorViewModel.swift
//  Controle
//
//  Created by Valéria Cavalcanti on 27/05/22.
//

import Foundation

class ContadorViewModel: ObservableObject{
    @Published var valor:Int = 0
    
    func incrementar(){
        if (self.valor < 10){
            self.valor += 1
        }   
    }
    
    func decrementar(){
        if (self.valor > 0){
            self.valor -= 1
        }
    }
}
