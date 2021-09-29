//
//  ViewController.swift
//  buyTickets
//
//  Created by Kate Reynolds on 9/28/21.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var ticketLabel: UILabel!
    @IBOutlet weak var ticketStepper: UIStepper!
    @IBOutlet weak var submitButton: UIButton!
    @IBOutlet weak var totalLabel: UILabel!
    
    @IBAction func updateTickets(_ sender: UIStepper) {
        if ticketStepper.value == 1 {
            ticketLabel.text = "1 ticket"
        } else {
            ticketLabel.text=String(format: "%.0f", ticketStepper.value) + " tickets"
        }
        updateTotal()
    }
    
    @IBAction func submitAction(_ sender: UIButton) {
        showAlert()
    }
    
    
    func updateTotal() {
        let numberOfTickets = ticketStepper.value
        if numberOfTickets == 1 {
            totalLabel.text = "Order Total: $75"
        } else {
            totalLabel.text = "Order Total: $" + String(format: "%.0f",numberOfTickets * 75)
        }
    }
    
    func showAlert() {
        let name = (nameTextField.text)!
        let alert = UIAlertController(
            title: "Congratulations, \(name)!",
            message: "You purchased tickets to Dead & Co.",
            preferredStyle: .alert)
        
        let add = UIAlertAction(title: "OK", style: .default, handler: nil)
        alert.addAction(add)
        
        present(alert, animated: true)
    }
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        nameTextField.delegate = self
        totalLabel.layer.borderColor = UIColor.darkGray.cgColor
        totalLabel.layer.borderWidth = 2.0
        
        super.viewDidLoad()

        //Dismiss keyboard when user taps outside
         let tap = UITapGestureRecognizer(target: self, action: #selector(UIInputViewController.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }

    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
}

