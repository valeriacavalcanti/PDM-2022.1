//
//  Tela01View.swift
//  ExemploTela
//
//  Created by Valéria Cavalcanti on 30/05/22.
//

import SwiftUI

struct Tela01View: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        Text("Tela 01")
            .frame(maxWidth: .infinity, maxHeight:.infinity)
            .background(Color.orange)
            .font(.title)
            .foregroundColor(.white)
            .onTapGesture {
                self.telaVM.tela = .principal
            }
    }
}

struct Tela01View_Previews: PreviewProvider {
    static var previews: some View {
        Tela01View(telaVM: TelaViewModel())
    }
}
