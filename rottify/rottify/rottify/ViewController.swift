//
//  ViewController.swift
//  rottify
//
//  Created by Kate Reynolds on 9/20/21.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

   
    @IBOutlet weak var fruitImage: UIImageView!
    @IBOutlet weak var fruitText: UILabel!
    @IBOutlet weak var rottingControl: UISegmentedControl!
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBOutlet weak var textColorControl: UISegmentedControl!
    @IBOutlet weak var fontSize: UILabel!
    
    func updateImage(){
        if rottingControl.selectedSegmentIndex == 0 {
            fruitText.text="Apple"
            fruitImage.image=UIImage(named: "apple1")
        }
        else if rottingControl.selectedSegmentIndex == 1 {
            fruitText.text="Rotten Apple"
            fruitImage.image=UIImage(named: "apple2")
        }
    }
    
    func updateColor() {
        if textColorControl.selectedSegmentIndex == 0 {
            fruitText.textColor = UIColor.black
        }
        else if textColorControl.selectedSegmentIndex == 1 {
            fruitText.textColor = UIColor.red
        }
    }
    
    func updateCaps(){
        if capitalSwitch.isOn {
            fruitText.text=fruitText.text?.uppercased()
        } else {
            fruitText.text=fruitText.text?.lowercased()
        }
    }
    
    @IBAction func capitalize(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontText=sender.value //float
        fontSize.text=String(format: "%.0f", fontText) //create a String from the float value
        let fontSizeCGFloat=CGFloat(fontText) //create a CGFloat from a float
        fruitText.font=UIFont.systemFont(ofSize: fontSizeCGFloat) //create a UIFont object and assign to the font property
    }
    
    @IBAction func changeFontColor(_ sender: UISegmentedControl) {
        updateColor()
    }
}
    

