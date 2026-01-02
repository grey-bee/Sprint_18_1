package com.example.sprint_18_1.test_screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint_18_1.R

class Screen3Activity : AppCompatActivity(R.layout.activity_screen_3) {

    // Описали callback для обработки нажатия на Back
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            showWarningToast()
            disableCallback()
        }
    }

    // Создали Handler для работы с postDelay
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Код без изменений

        // Добавляем созданный callback к Dispatcher
        onBackPressedDispatcher.addCallback(this, callback)
        findViewById<Button>(R.id.screen3ButtonToScreen1WithClear).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back to Screen 1'")
            backToScreen1()
        }
    }
    private fun backToScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        this.startActivity(intent)
    }

    // Показываем Toast с предупреждением
    private fun showWarningToast() {
        Toast.makeText(this, "Нажмите ещё раз, чтобы перейти на предыдущий экран", Toast.LENGTH_SHORT).show()
    }

    private fun disableCallback() {
        // Отключаем callback
        callback.isEnabled = false

        // И через две секунды включаем его обратно
        handler.postDelayed({
            callback.isEnabled = true
        }, 2000L)
    }

    // Код без изменений

}