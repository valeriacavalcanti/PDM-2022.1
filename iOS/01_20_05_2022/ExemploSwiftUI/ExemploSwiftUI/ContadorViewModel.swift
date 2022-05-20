//
//  ContadorModelView.swift
//  ExemploSwiftUI
//
//  Created by Valéria Cavalcanti on 20/05/22.
//

import Foundation

class ContadorViewModel: ObservableObject{
    @Published var count:Int = 0
    
    func incrementar() {
        self.count += 1
    }
    
    func decrementar(){
        self.count -= 1
    }
}
