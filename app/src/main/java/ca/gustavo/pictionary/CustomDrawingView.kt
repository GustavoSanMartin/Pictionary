package ca.gustavo.pictionary

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.View

private const val STROKE_WIDTH = 20F
private const val PAINT_COLOR = 0xFF660000.toInt()

class CustomDrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val drawPath = Path()
    private val canvasPaint = Paint(Paint.DITHER_FLAG)
    private lateinit var drawCanvas: Canvas
    private lateinit var canvasBitmap: Bitmap

    private val drawPaint = Paint().apply {
        color = PAINT_COLOR
        strokeWidth = STROKE_WIDTH
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(canvasBitmap, 0F, 0F, canvasPaint)
        canvas?.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            ACTION_DOWN -> drawPath.moveTo(event.x, event.y)
            ACTION_MOVE -> drawPath.lineTo(event.x, event.y)
            ACTION_UP -> {
                drawCanvas.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
            else -> return false
        }

        invalidate()
        return true
    }
}