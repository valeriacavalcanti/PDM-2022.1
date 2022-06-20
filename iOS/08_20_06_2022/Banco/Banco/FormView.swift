//
//  FormView.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 20/06/22.
//

import SwiftUI

struct FormView: View {
    @State private var nome:String = ""
    @State private var idade:String = ""
    @Environment(\.presentationMode) private var presentation
    @Environment(\.managedObjectContext) private var viewContext
    
    var body: some View {
        Form{
            Section {
                TextField("Nome", text: self.$nome)
            } header: {
                Text("Nome")
            }
            
            Section {
                TextField("Idade", text: self.$idade)
            } header: {
                Text("Idade")
            }
        }
        .navigationTitle("Formulário")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Button("Salvar"){
                    withAnimation {
                        let pessoa = Pessoa(context: viewContext)
                        pessoa.nome = self.nome
                        pessoa.idade = Int16(self.idade) ?? 0

                        do {
                            try viewContext.save()
                        } catch {
                            let nsError = error as NSError
                            fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
                        }
                    }
                    
                    self.presentation.wrappedValue.dismiss()
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
