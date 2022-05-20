//
//  ViewController.swift
//  ExemploUIKit
//
//  Created by Valéria Cavalcanti on 20/05/22.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var lbCont: UILabel!
    var contador = 0
    
    @IBAction func incrementar(_ sender: Any) {
        self.contador += 1
        self.lbCont.text = self.contador.description
    }
    
    @IBAction func decrementar(_ sender: Any) {
        self.contador -= 1
        self.lbCont.text = self.contador.description
    }
    
}

