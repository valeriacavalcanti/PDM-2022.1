//
//  ContentView.swift
//  Controle
//
//  Created by Valéria Cavalcanti on 27/05/22.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var contadorVM: ContadorViewModel
    @State var valor:Int = 0
    
    var body: some View {
        VStack{
            contador
            HStack{
                MyButtonAdd(valorLocal: self.$contadorVM.valor)
                btDecrementar
            }
        }
    }
}

extension ContentView{
    var contador: some View{
        Text(self.contadorVM.valor.description)
            .font(.title)
            .foregroundColor(.blue)
    }
}

extension ContentView{
    var btDecrementar: some View{
        Button {
            self.contadorVM.decrementar()
        } label: {
            Label("", systemImage: "minus.circle.fill")
                .font(.title)
                .foregroundColor(.red)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(contadorVM: ContadorViewModel())
    }
}
