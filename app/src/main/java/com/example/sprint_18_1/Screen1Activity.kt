package com.example.sprint_18_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Screen1Activity : AppCompatActivity(R.layout.activity_screen1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("NAVEXAMPLE", "Screen1 -> onCreate")

        findViewById<TextView>(R.id.screen1Title).text = "Screen 1 [$this]"

        findViewById<Button>(R.id.screen1ButtonToScreen2).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen1 -> Click on 'To screen 2'")
            openScreen2()
        }
    }

    private fun openScreen2() {
        val intent = Intent(this, Screen2Activity::class.java)

        this.startActivity(intent)
    }

}