//
//  FormView.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 03/06/22.
//

import SwiftUI

struct FormView: View {
    @State var nome: String = ""
    @State var idade: String = ""
    @EnvironmentObject var agendaVM: AgendaViewModel
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        VStack{
            Spacer()
            TextField("Nome", text: self.$nome)
                .padding()
                .border(.blue)
            Spacer()
            TextField("Idade", text: self.$idade)
                .padding()
                .border(.blue)
            Spacer()
        }
        .padding()
        .navigationTitle("Formulário")
        .toolbar {
            ToolbarItemGroup(placement: .navigationBarTrailing) {
                Button("Salvar") {
                    let pessoa = Pessoa(nome: self.nome, idade: Int(self.idade)!)
                    self.agendaVM.lista.append(pessoa)
                    self.presentationMode.wrappedValue.dismiss()
                }
            }
        }
    }
}

struct FormView_Previews: PreviewProvider {
    static var previews: some View {
        FormView()
    }
}
