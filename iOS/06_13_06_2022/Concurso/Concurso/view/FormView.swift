//
//  FormView.swift
//  Concurso
//
//  Created by Valéria Cavalcanti on 13/06/22.
//

import SwiftUI

struct FormView: View {
    @State var nome:String = ""
    @State var curso:String = "CSTSI"
    @EnvironmentObject var concursoVM: ConcursoViewModel
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        VStack{
            Spacer()
            TextField("Nome", text: self.$nome)
            Spacer()
            Picker("Curso", selection: self.$curso) {
                Text("Integrado em Informática").tag("CTIN")
                Text("Mestrado em TI").tag("PPGTI")
                Text("Redes de Computadores").tag("CSTRC")
                Text("Sistemas para Internet").tag("CSTSI")
            }
            .pickerStyle(.inline)
            Spacer()
        }
        .padding()
        .navigationTitle("Formulário")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Button("Salvar"){
                    let p = Pessoa(nome: self.nome, curso: self.curso)
                    self.concursoVM.lista.append(p)
                    self.dismiss()
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
