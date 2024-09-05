package com.jummania.spinwheellibrary

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jummania.Wheel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wheel = findViewById<Wheel>(R.id.wheel)

        var rotation = wheel.rotation
        var speed = 1f
        val handler = Handler(mainLooper)
        wheel.setColors(arrayOf(
            Color.parseColor("#4b0081"),
            Color.parseColor("#0000fe"),
            Color.parseColor("#008001"),
            Color.parseColor("#ffff00"),
            Color.parseColor("#ff7f00"),
            Color.parseColor("#fe0000"),
            Color.parseColor("#9400d4")
        ))

        wheel.setOnClickListener {
            wheel.animate().rotation(wheel.rotation+54000).setDuration(30000).start()
            /*
            handler.post {
                rotation += speed
                wheel.rotation = rotation
                if (speed < 50) speed += 0.05f
                // handler.post(this)
            }

             */
        }

    }
}