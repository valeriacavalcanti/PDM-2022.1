//
//  ContentView.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 03/06/22.
//

import SwiftUI

struct ContentView: View {
    @StateObject var agendaVM = AgendaViewModel()
    
    var body: some View {
        NavigationView{
            main
        }
    }
}

extension ContentView{
    var main: some View{
        VStack{
            Text("Pessoas: \(self.agendaVM.lista.count.description)")
                .font(.largeTitle)
                .padding()
            List(self.agendaVM.lista){ pessoa in
                //Text(pessoa.nome)
                NavigationLink(pessoa.nome, destination: Text(pessoa.description))
            }
        }
        .navigationTitle("Pessoas")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItemGroup(placement: .navigationBarLeading) {
                // esquerda
            }
            ToolbarItemGroup(placement: .navigationBarTrailing) {
                NavigationLink(destination: FormView().environmentObject(self.agendaVM)) {
                    Image(systemName: "plus")
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
