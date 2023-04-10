package com.example.sharedpreferancesthirddemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//1. we inti the variables
    private val PREFS_NAME = "MyPrefsFile"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var textView: TextView
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//2.we give them the ids in the onCreate function,init the shared preferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        textView = findViewById(R.id.text_view)
        saveButton = findViewById(R.id.save_button)
//4.when click you save the value in the data key
        saveButton.setOnClickListener {
            val editor = sharedPreferences.edit()//like open file i use .edit
            editor.putString("data", "Hello World!")
            editor.apply()//close file
            textView.text = "Data saved in SharedPreferences"
        }
//3.we check if there any data save in the sharepref this retrun null when there is no data saved in the key
        val savedData = sharedPreferences.getString("data", null)
        if (savedData != null) {
            textView.text = "Data retrieved from SharedPreferences:\n$savedData"
        }
    }
}


