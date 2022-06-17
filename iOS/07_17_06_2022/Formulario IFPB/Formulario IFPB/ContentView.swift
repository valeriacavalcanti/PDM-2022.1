//
//  ContentView.swift
//  Formulario IFPB
//
//  Created by Valéria Cavalcanti on 17/06/22.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView{
            VStack{
                Text("Formulário")
                    .font(.largeTitle)
                    .padding()
                NavigationLink("Abrir", destination: FormView())
                    .font(.largeTitle)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
