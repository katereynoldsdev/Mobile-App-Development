package com.example.boulderthai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createOrder(view: View) {
        var pickupDelivery : CharSequence = ""
        var meal = ""
        var wUtensils = ""
        var counter = 0

        //views
        val layoutRoot = findViewById<ConstraintLayout>(R.id.constraint_layout)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val pickupValue = radioGroup.checkedRadioButtonId
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val switch = findViewById<SwitchMaterial>(R.id.utensil_switch)

        if (pickupValue == -1) {
            Log.i("if statement", "$pickupValue")
            //Snackbar
            val snackbarVar =
                Snackbar.make(layoutRoot, "Please select pickup or delivery", Snackbar.LENGTH_SHORT)
            snackbarVar.show()
        } else {
            //Pickup or Delivery
            Log.i("else statement", "$pickupValue")
            pickupDelivery = findViewById<RadioButton>(pickupValue).text.toString()

            //Checkboxes
            if (checkBox1.isChecked) {
                counter += 1
                if(counter>1) {
                    meal += ", " + checkBox1.text
                }
                else {
                    meal += checkBox1.text
                }
            }
            if (checkBox2.isChecked) {
                counter += 1
                if(counter>1) {
                    meal += ", " + checkBox2.text
                }
                else {
                    meal += checkBox2.text
                }
            }
            if (checkBox3.isChecked) {
                counter += 1
                if(counter>1) {
                    meal += ", " + checkBox3.text
                }
                else {
                    meal += checkBox3.text
                }
            }

            //Utensils Switch
            if(switch.isChecked) {
                wUtensils = "with utensils"
            }

            //Spinner
            val timer = spinner.selectedItem

            //TextView
            messageTextView.text = "You ordered $meal $wUtensils for $timer $pickupDelivery"
        }
    }
}