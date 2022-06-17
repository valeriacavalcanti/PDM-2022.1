//
//  FormView.swift
//  Formulario IFPB
//
//  Created by Valéria Cavalcanti on 17/06/22.
//

import SwiftUI
//import UIKit

struct FormView: View {
    @State private var nome:String = ""
    @State private var idade:String = ""
    @State private var nascimento:Date = Date()
    @State private var curso:String = ""
    @State private var periodo:Int = 1
    @State private var concluinte:Bool = false
    @State private var cor:Color = .white
    @State private var imagem:String = "hifpb"
    @FocusState private var keyboard:Bool
    
    var body: some View {
        Form{
            Section("Dados Pessoais"){
                TextField("Nome", text: self.$nome)
                    .focused(self.$keyboard)
                TextField("Idade", text: self.$idade)
                    .focused(self.$keyboard)
                    .keyboardType(.numberPad)
                DatePicker("Nascimento", selection: self.$nascimento, displayedComponents: .date)
            }
            
            Section("Dados Acadêmicos"){
                Picker("Curso", selection: self.$curso) {
                    Text("Integrado em Informática").tag("CTIN")
                    Text("Mestrado em TI").tag("PPGTI")
                    Text("Redes de Computadores").tag("CSTRC")
                    Text("Sistemas para Internet").tag("CSTSI")
                }
                
                Stepper("Período/Ano: \(self.periodo)", value: self.$periodo, in: 1...10)
                
                Toggle("Concluinte", isOn: self.$concluinte)
            }
            
            Section("Configurações"){
                ColorPicker("Cor", selection: self.$cor)
            }
            .listRowBackground(self.cor)
            
            Section("IFPB"){
                Picker("", selection: self.$imagem) {
                    Text("Horizontal").tag("hifpb")
                    Text("Vertical").tag("vifpb")
                }
                .pickerStyle(.segmented)
//                .pickerStyle(InlinePickerStyle())
//                .pickerStyle(MenuPickerStyle())
//                .pickerStyle(SegmentedPickerStyle())
//                .pickerStyle(WheelPickerStyle())
                HStack{
                    Spacer()
                    Image(self.imagem)
                        .resizable()
                        .scaledToFit()
                        .frame(height: 140)
                    Spacer()
                }
                
                Link("Site", destination: URL(string: "http://www.ifpb.edu.br")!)
            }
        }
        .navigationTitle("Formulário")
        .navigationBarTitleDisplayMode(.inline)
//        .onTapGesture {
//            fechar()
//            print("clique")
//        }
//        .onLongPressGesture(perform: {
//            print("clique longo")
//        })
        .toolbar {
            ToolbarItemGroup(placement: .keyboard) {
                Spacer()
                Button("Fechar"){
                    self.keyboard = false
//                    fechar()
                }
            }
        }
    }
    
//    Só vai dar certo se adicionar um botão na interface para chamar essa função.
//    func fechar() {
//        UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
//    }
}

struct FormView_Previews: PreviewProvider {
    static var previews: some View {
        FormView()
    }
}
