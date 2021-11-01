package com.example.greeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayGreeting(view: android.view.View) {
        //EditText
        val editName = findViewById<EditText>(R.id.editTextName)
        val name = editName.text

        //TextView
        val greetings = arrayOf("Hello", "Hola", "Bonjour", "Guten tag", "Salve")
        var newGreeting = greetings.random()
        val greetingText = findViewById<TextView>(R.id.textMessage)
        greetingText.text = "$newGreeting $name!"

        //ImageView
        val imageHand = findViewById<ImageView>(R.id.imageView)
        imageHand.setImageResource(R.drawable.hand)
    }
}