//
//  ViewController.swift
//  Season Selector
//
//  Created by Kate Reynolds on 9/1/21.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
    }

    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag==1 {
            artImage.image=UIImage(named:"Winter")
            changeText.text = "Winter"
        }
        else if sender.tag==2 {
            artImage.image=UIImage(named:"Spring")
            changeText.text = "Spring"
        }
        else if sender.tag==3 {
            artImage.image=UIImage(named:"Summer")
            changeText.text = "Summer"
        }
        else if sender.tag==4 {
            artImage.image=UIImage(named:"Fall")
            changeText.text = "Fall"
        }
    }
    
    @IBOutlet weak var changeText: UITextField!
    @IBOutlet weak var artImage: UIImageView!
}

