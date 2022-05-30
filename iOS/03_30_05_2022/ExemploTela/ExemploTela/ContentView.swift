//
//  ContentView.swift
//  ExemploTela
//
//  Created by Valéria Cavalcanti on 30/05/22.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var telaVM: TelaViewModel
    
    var body: some View {
        if (self.telaVM.tela == .principal){
            principal
        }else if (self.telaVM.tela == .tela01){
            Tela01View(telaVM: self.telaVM)
        }
    }
}

extension ContentView{
    var principal: some View{
        NavigationView{
            VStack{
                Spacer()
                Text("Principal")
                    .padding()
                Spacer()
                Button("Tela 01"){
                    self.telaVM.tela = .tela01
                }
                Spacer()
                NavigationLink("Tela 02") {
                    Tela02View()
                }
                Spacer()
            }
            .navigationTitle("Principal")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(telaVM: TelaViewModel())
    }
}
