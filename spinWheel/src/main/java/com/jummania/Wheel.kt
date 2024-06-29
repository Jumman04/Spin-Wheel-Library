package com.jummania

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 *  * Created by Jummania on 29,June,2024.
 *  * Email: sharifuddinjumman@gmail.com
 *  * Dhaka, Bangladesh.
 */
class Wheel @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    private val angle = 8
    private val paint = Paint().also { it.isAntiAlias = true }
    private val path = Path()
    private val colors = arrayOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA,
        Color.LTGRAY,
        Color.DKGRAY
    )

    override fun onDraw(canvas: Canvas) {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = min(centerX, centerY)
        val sectorAngle = 360f / angle

        paint.color = Color.parseColor("#70578e")
        for (i in 0 until angle) {
            val startAngle = 2f * i * sectorAngle
          //  paint.color = colors[i % colors.size]

           // path.reset()
            path.moveTo(centerX, centerY)
            path.lineTo(
                centerX + radius * cos(Math.toRadians(startAngle.toDouble())).toFloat(),
                centerY + radius * sin(Math.toRadians(startAngle.toDouble())).toFloat()
            )
            path.arcTo(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle,
                sectorAngle,
                false
            )
            path.close()
            canvas.drawPath(path, paint)
        }

        paint.color = Color.parseColor("#34105E")
        canvas.drawCircle(centerX, centerY, radius / 4, paint)
    }
}