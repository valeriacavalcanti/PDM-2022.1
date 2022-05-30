//
//  Tela02View.swift
//  ExemploTela
//
//  Created by Valéria Cavalcanti on 30/05/22.
//

import SwiftUI

struct Tela02View: View {
//    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        Text("Tela 02")
            .frame(maxWidth: .infinity, maxHeight:.infinity)
            .background(Color.purple)
            .font(.title)
            .foregroundColor(.white)
//            .onTapGesture {
//                self.telaVM.tela = .principal
//            }
            .navigationTitle("Tela 02")
            .navigationBarTitleDisplayMode(.inline)
    }
}

struct Tela02View_Previews: PreviewProvider {
    static var previews: some View {
        Tela02View()
    }
}
