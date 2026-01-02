package com.example.sprint_18_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.sprint_18_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            // в этот момент мы отображаем Fragment
//            supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container_view, CitiesFragment())
//                .commit()
            supportFragmentManager.commit {
                add<CitiesFragment>(R.id.fragment_container_view)
            }
        }
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.replaceCountryFragment.setOnClickListener {
            // в этот момент мы заменяем Fragment со списком городов на Fragment со списком стран
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container_view, CountriesFragment())
//                .setReorderingAllowed(true)
//                .commit()
            supportFragmentManager.commit {
                replace<CountriesFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
            }

        }
        binding.replaceBackStackCountryFragment.setOnClickListener {
            // в этот момент мы заменяем Fragment со списком городов на Fragment со списком стран, при этом сохраняя Fragment со списком городов в Back Stack
            supportFragmentManager.commit {
                addToBackStack("my_backstack")
                replace<CountriesFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
            }
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container_view, CountriesFragment())
//                .addToBackStack("my_backstack")
//                .setReorderingAllowed(true)
//                .commit()
        }
    }

}