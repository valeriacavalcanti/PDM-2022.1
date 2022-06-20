//
//  ContentView.swift
//  Banco
//
//  Created by Valéria Cavalcanti on 20/06/22.
//

import SwiftUI
import CoreData

struct ContentView: View {
    @Environment(\.managedObjectContext) private var viewContext

    @FetchRequest(
        sortDescriptors: [NSSortDescriptor(keyPath: \Pessoa.nome, ascending: true)],
        animation: .default)
    private var pessoas: FetchedResults<Pessoa>

    var body: some View {
        NavigationView {
            List {
                ForEach(pessoas) { pessoa in
                    NavigationLink {
                        Text("Pessoa: \(pessoa.nome!) - Idade: \(pessoa.idade)")
                    } label: {
                        Text("Pessoa: \(pessoa.nome!) - Idade: \(pessoa.idade)")
                    }
                }
                .onDelete(perform: delete)
            }
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    EditButton()
                }
                ToolbarItem {
                    NavigationLink {
                        FormView()
                    } label: {
                        Image(systemName: "plus")
                    }

                }
            }
            //Text("Select an item")
        }
    }

    private func delete(offsets: IndexSet) {
        withAnimation {
            offsets.map { self.pessoas[$0] }.forEach(viewContext.delete)

            do {
                try viewContext.save()
            } catch {
                // Replace this implementation with code to handle the error appropriately.
                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
                let nsError = error as NSError
                fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environment(\.managedObjectContext, PersistenceController.preview.container.viewContext)
    }
}
