//
//  ControleApp.swift
//  Controle
//
//  Created by Valéria Cavalcanti on 27/05/22.
//

import SwiftUI

@main
struct ControleApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(contadorVM: ContadorViewModel())
        }
    }
}
