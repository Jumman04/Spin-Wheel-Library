package com.jummania.spinwheellibrary

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jummania.Wheel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wheel = findViewById<Wheel>(R.id.wheel)

        wheel.setOnClickListener {
            var rotation = wheel.rotation
            var speed = 1f
            val handler = Handler(mainLooper)
            handler.post(object : Runnable {
                override fun run() {
                    rotation += speed
                    wheel.rotation = rotation
                    if (speed < 15) speed += 0.05f
                    handler.post(this)
                }

            })
        }

    }
}