//
//  ContentView.swift
//  Pessoa do Milho
//
//  Created by Valéria Cavalcanti on 06/06/22.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView{
            ZStack{
                Rectangle()
                    .foregroundColor(.yellow)
                    .edgesIgnoringSafeArea(.top)
                    .opacity(0.2)
                Rectangle()
                    .foregroundColor(.white)
                VStack{
                    listaVazia
                }
                .navigationTitle("Candidatas")
                .toolbar {
                    ToolbarItem(placement: .navigationBarTrailing) {
                        NavigationLink(destination: EmptyView()) {
                            Image(systemName: "plus")
                        }
                    }
                }
            }
        }
    }
}

extension ContentView{
    var listaVazia: some View{
        VStack{
            Group{
                Image(systemName: "cloud")
                    .resizable()
                    .frame(width: 100, height: 80)
                    .scaledToFit()
                    .padding()
                Text("Nenhuma pessoa cadastrada")
                    .font(.title2)
            }
            .foregroundColor(.gray)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
