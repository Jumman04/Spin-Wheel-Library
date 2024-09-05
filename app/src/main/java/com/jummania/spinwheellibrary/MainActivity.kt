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

        var rotation = wheel.rotation
        var speed = 1f
        val handler = Handler(mainLooper)
        wheel.setColors(
            "#4b0081", "#0000fe", "#008001", "#ffff00", "#ff7f00", "#fe0000", "#9400d4", "#FFFFFF"
        )

        wheel.setOnClickListener {
            wheel.animate().rotation(wheel.rotation + 55555).setDuration(30000).start()/*
            handler.post(object : Runnable {
                override fun run() {
                    rotation += speed
                    wheel.rotation = rotation
                    if (speed < 40)
                        speed += 0.05f
                    handler.post(this)
                }
            })

               */
        }

    }
}