package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

// This Kotlin file is where we're going to be handling user interaction
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Shows the layout file: activity_main
        setContentView(R.layout.activity_main)

        // Allow user to tap a button to change the text color of the label
        // Get a reference to button
        // Set up logic to know when the user has tapped on "Change Text Color"
        findViewById<Button>(R.id.button).setOnClickListener {
            // Handle button Tap
            Log.i("TextColorButton", "Tapped on text color button")
            // Get a reference to the text view
            // Set the color of the text view
            findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.teal_700))
        }

        // Set up logic to know when user has tapped "Change Background Color" Button
        findViewById<Button>(R.id.button2).setOnClickListener {
            Log.i("BackgroundColorButton", "Tapped on Background color button")
            findViewById<ConstraintLayout>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.white))
        }



        // Set up logic to know when user has tapped the "Change Text String" Button
        findViewById<Button>(R.id.button3).setOnClickListener {
            // Get the text the user has entered into the Edit Text
            val simpleEditText = findViewById<EditText>(R.id.et_simple) as EditText
            val strValue = simpleEditText.text.toString()
            // Check to see if the string is blank
            if (strValue == "")
            {
                findViewById<TextView>(R.id.textView).text = "Android is Awesome!"
                Log.i("userText", "No text entered: Setting to default")
            }
            else
            {
                findViewById<TextView>(R.id.textView).text = strValue
                Log.i("userText", strValue)
            }
        }

        // Set up logic to know when user has tapped the Background to reset all views to default settings
        findViewById<ConstraintLayout>(R.id.backgroundView).setOnClickListener {
            findViewById<ConstraintLayout>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.lime))
            findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.black))
            findViewById<TextView>(R.id.textView).setText("Hello from Ethan!")
            Log.i("resetViews", "All views reset")
        }
    }
}