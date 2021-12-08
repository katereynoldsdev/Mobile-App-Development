package com.example.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
//ML Kit Translation Documentation - https://developers.google.com/ml-kit/language/translation/android

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val translatedText: TextView = findViewById(R.id.translatedText)
        val button: Button = findViewById(R.id.translateButton)
        val spinner: Spinner = findViewById(R.id.spinner)
        var language: String

        button.setOnClickListener() {
            //if user doesn't enter text
            if(editText.text.isEmpty()) {
                Toast.makeText(this, "Please enter text.", Toast.LENGTH_SHORT).show()
            }
            else {
                //language selected from spinner
                var input: String = spinner.selectedItem.toString()
                input = input.uppercase()
                language = languageSelector(input)

                val options = TranslatorOptions.Builder()
                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                    .setTargetLanguage(language)
                    .build()

                //Make sure required translation model has been downloaded to the device
                val conditions = DownloadConditions.Builder()
                    .requireWifi()
                    .build()

                val translator = Translation.getClient(options)
                translator.downloadModelIfNeeded(conditions)

                //see if translator works - will translate text if it does
                translator.translate(editText.text.toString())
                    .addOnSuccessListener {
                        translatedText.text= it
                    }
                    .addOnFailureListener {
                        translatedText.text= "Unable to translate"
                    }
            }
        }
    }

    fun languageSelector(input: String): String {
        if(input=="SPANISH") {
            return TranslateLanguage.SPANISH
        }
        if(input=="ITALIAN") {
            return TranslateLanguage.ITALIAN
        }
        if(input=="GERMAN") {
            return TranslateLanguage.GERMAN
        }
        return ""
    }
}