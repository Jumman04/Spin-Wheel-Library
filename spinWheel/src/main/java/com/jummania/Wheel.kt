package com.jummania

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Keep
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 *  * Created by Jummania on 29,June,2024.
 *  * Email: sharifuddinjumman@gmail.com
 *  * Dhaka, Bangladesh.
 */

@Keep
open class Wheel @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var angle = 0
    private val paint = Paint().also { it.isAntiAlias = true }
    private val path = Path()
    private var colors: IntArray = intArrayOf()

    override fun onDraw(canvas: Canvas) {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = min(centerX, centerY)
        val sectorAngle = 360f / angle

        for (i in 0 until angle) {
            val startAngle = i * sectorAngle
            paint.color = colors[i % colors.size]

            path.reset()
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

        //  paint.color = Color.WHITE
        //   canvas.drawCircle(centerX, centerY, radius / 4, paint)
    }

    fun setColors(vararg colorArray: Int) {
        colors = colorArray
        angle = colors.size
        invalidate()
    }

    fun setColors(vararg colorArray: String) {
        colors = intArrayOf()
        for (i in colorArray.indices) {
            colors += intArrayOf(Color.parseColor(colorArray[i]))
        }
        angle = colors.size
        invalidate()
    }

    fun setAngle(angle: Int) {
        this.angle = angle
    }

    fun getColors(): IntArray {
        return colors
    }

    fun getAngle(): Int {
        return angle
    }

    private fun parseColor(color: String): Int {
        return Color.parseColor(color)
    }
}