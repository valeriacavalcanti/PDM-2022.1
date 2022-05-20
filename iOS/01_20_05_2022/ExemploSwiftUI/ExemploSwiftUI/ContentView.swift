//
//  ContentView.swift
//  ExemploSwiftUI
//
//  Created by Valéria Cavalcanti on 20/05/22.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var contadorVM: ContadorViewModel
    
    var body: some View {
        VStack{
            Spacer()
            contador
            Spacer()
            HStack{
                Spacer()
                btIncrementar
                Spacer()
                btDecrementar
                Spacer()
            }
            Spacer()
        }
    }
}

extension ContentView{
    var contador: some View{
        Text(self.contadorVM.count.description)
            .padding()
            .font(.title)
    }
}

extension ContentView{
    var btIncrementar: some View{
        Button {
            self.contadorVM.incrementar()
        } label: {
            Label("", systemImage: "plus.circle.fill")
                .font(.title)
                .foregroundColor(.green)
        }
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
