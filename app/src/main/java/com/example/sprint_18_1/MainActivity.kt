package com.example.sprint_18_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // в этот момент мы отображаем Fragment
//            supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container_view, CitiesFragment())
//                .commit()
            supportFragmentManager.commit {
                add<CitiesFragment>(R.id.fragment_container_view)
            }
        }
    }

}