//
//  ExemploSwiftUIApp.swift
//  ExemploSwiftUI
//
//  Created by Valéria Cavalcanti on 20/05/22.
//

import SwiftUI

@main
struct ExemploSwiftUIApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView(contadorVM: ContadorViewModel())
        }
    }
}
