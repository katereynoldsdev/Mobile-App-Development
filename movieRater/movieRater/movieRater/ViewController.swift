//
//  ViewController.swift
//  movieRater
//
//  Created by Kate Reynolds on 9/27/21.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var addMovieButton: UIButton!
    @IBOutlet weak var movieTextField: UITextField!
    @IBOutlet weak var oneStarButton: UIButton!
    @IBOutlet weak var twoStarButton: UIButton!
    @IBOutlet weak var threeStarButton: UIButton!
    @IBOutlet weak var fourStarButton: UIButton!
    @IBOutlet weak var fiveStarButton: UIButton!
    @IBOutlet weak var alertView: UIView!
    
    var ratingValue: Int = 0
    var ratings = [5, 3, 5]
    var data = ["Jaws","Booksmart", "Whiplash"]
    
    //KEYBOARD
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        alertView.isHidden = true
        tableView.delegate = self
        tableView.dataSource = self
        movieTextField.delegate = self
        
        //Dismiss keyboard when user taps outside
        let tap = UITapGestureRecognizer(target: self, action: #selector(UIInputViewController.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
    

    func showAlert() {
        alertView.isHidden = false
    }
    
    @IBAction func clickButton(_ sender: UIButton) {
        showAlert()
    }
    
    @IBAction func starButtonsPressed(_ sender: UIButton) {
        updateStarButtons(forNumStars: sender.tag)
        ratingValue = sender.tag
    }
    
    func updateStarButtons(forNumStars numStars: Int) {
        let buttons = [oneStarButton, twoStarButton, threeStarButton, fourStarButton, fiveStarButton]
        var i = 0
        for button in buttons {
            if numStars > i {
                button?.setImage(UIImage(systemName: "star.fill"), for: .normal)
            }
            else {
                button?.setImage(UIImage(systemName: "star"), for: .normal)
            }
            i += 1
        }
    }
    
    func resetAlertView() {
        oneStarButton.setImage(UIImage(systemName: "star"), for: .normal)
        twoStarButton.setImage(UIImage(systemName: "star"), for: .normal)
        threeStarButton.setImage(UIImage(systemName: "star"), for: .normal)
        fourStarButton.setImage(UIImage(systemName: "star"), for: .normal)
        fiveStarButton.setImage(UIImage(systemName: "star"), for: .normal)
        movieTextField.text = ""
    }

    
    @IBAction func cancelButtonPressed(_ sender: UIButton) {
        alertView.isHidden = true
        resetAlertView()
    }
    
    @IBAction func addButtonPressed(_ sender: UIButton) {
        //Update table with movie name and rating
        if let text = movieTextField.text {
            data.append(text)
            ratings.append(ratingValue)
            tableView.reloadData()
        }

        alertView.isHidden = true
        resetAlertView()
    }
    
    
}

extension ViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("you tapped me")
    }
}
extension ViewController: UITableViewDataSource {
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath) as! TableViewCell
//        cell.textLabel?.text = data[indexPath.row]
        cell.movieTitleLabel.text = data[indexPath.row]
        cell.ratingLabel.text = "Rating: \(ratings[indexPath.row])"
        return cell
    }
}
