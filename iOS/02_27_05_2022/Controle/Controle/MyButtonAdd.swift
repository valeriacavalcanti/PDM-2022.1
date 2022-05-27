//
//  MyButton.swift
//  Controle
//
//  Created by Valéria Cavalcanti on 27/05/22.
//

import SwiftUI

struct MyButtonAdd: View {
    @Binding var valorLocal:Int
    
    var body: some View {
        Button {
            self.valorLocal += 1
        } label: {
            Label("", systemImage: "plus.circle.fill")
                .font(.title)
                .foregroundColor(.green)
        }
    }
}
