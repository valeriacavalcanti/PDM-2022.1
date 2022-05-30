//
//  ExemploTelaApp.swift
//  ExemploTela
//
//  Created by Valéria Cavalcanti on 30/05/22.
//

import SwiftUI

@main
struct ExemploTelaApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(telaVM: TelaViewModel())
        }
    }
}
