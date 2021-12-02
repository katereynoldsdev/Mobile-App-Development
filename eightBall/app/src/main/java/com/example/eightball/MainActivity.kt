package com.example.eightball

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    lateinit var askBtn : Button
    lateinit var questionText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //views
        askBtn = findViewById(R.id.askButton)
        questionText = findViewById(R.id.questionTextView)

        //intent to change activity
        askBtn.setOnClickListener() {
            val intent = Intent(this, FortuneActivity::class.java)
            intent.putExtra("Question", questionText.text.toString())
            startActivity(intent)
        }
    }
}