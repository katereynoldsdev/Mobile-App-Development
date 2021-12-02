package com.example.eightball

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.eightball.databinding.ActivityFortuneBinding

class FortuneActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityFortuneBinding

    private var question: String? = null
    private var answer: String? = null
    var myQuestion = questionClass2();

    lateinit var questionSecondView: TextView
    lateinit var fortuneTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFortuneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //views
        questionSecondView = findViewById(R.id.questionSecondView)
        fortuneTextView = findViewById(R.id.fortuneTextView)

        //action bar - back arrow
        val actionBar = supportActionBar
        actionBar!!.title = "Fortune"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Get data from previous activity for question
        question = intent.getStringExtra("Question")
        questionSecondView.text = question
        //answer
        myQuestion.selectFortune()
        answer = myQuestion.fortune
        fortuneTextView.text = answer


//        val navController = findNavController(R.id.nav_host_fragment_content_fortune)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setImageResource(R.drawable.cart);
        binding.fab.setOnClickListener { view -> visitWebsite()
        }
    }

    private fun visitWebsite() {
        val url = "https://www.amazon.com/Mattel-Games-Magic-8-Ball/dp/B00001ZWV7"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_fortune)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
//}