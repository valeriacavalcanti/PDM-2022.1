//
//  ContentView.swift
//  Concurso
//
//  Created by Valéria Cavalcanti on 13/06/22.
//

import SwiftUI

struct ContentView: View {
    @StateObject var concursoVM = ConcursoViewModel()
    
    var body: some View {
        NavigationView{
            ZStack{
                Color.yellow
                    .opacity(0.2)
                    .edgesIgnoringSafeArea(.top)
                Color.white
                if (self.concursoVM.lista.isEmpty){
                    telaVazia
                }else{
                    List{
                        ForEach(self.concursoVM.getAll()){ pessoa in
                            CellView(pessoa: pessoa)
                        }
                        .onDelete(perform: delete)
                        .onMove(perform: move)
                    }
                    .listStyle(.plain)
                }
            }
            .navigationTitle("Pessoas")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    NavigationLink {
                        FormView()
                    } label: {
                        Image(systemName: "plus")
                    }
                }
                ToolbarItem(placement: .navigationBarLeading) {
                    EditButton()
                }
            }
            .onAppear{
                print(self.concursoVM.lista.description)
            }
        }
        .environmentObject(self.concursoVM)
    }
    
    func delete(index: IndexSet){
        self.concursoVM.lista.remove(atOffsets: index)
    }
    
    func move(from: IndexSet, to: Int){
        self.concursoVM.lista.move(fromOffsets: from, toOffset: to)
    }
}

extension ContentView{
    var telaVazia: some View{
        VStack{
            Group{
                Image(systemName: "cloud")
                    .resizable()
                    .frame(width: 100, height: 80)
                Text("Nenhum candidato cadastrado!")
                    .font(.title2)
            }
            .foregroundColor(.gray)
            .padding()
        }
    }
}

struct CellView: View{
    @ObservedObject var pessoa: Pessoa
    
    var body: some View{
        HStack{
            Image(systemName: pessoa.inicial_curso())
                .font(.largeTitle)
            VStack(alignment: .leading){
                Text(self.pessoa.nome)
                    .fontWeight(.bold)
                Text("Votos: \(self.pessoa.votos)")
            }
            Spacer()
            Button {
                self.pessoa.votos += 1
            } label: {
                Image(systemName: "plus")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
