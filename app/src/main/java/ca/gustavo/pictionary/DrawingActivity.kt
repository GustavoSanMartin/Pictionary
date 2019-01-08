package ca.gustavo.pictionary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DrawingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
    }
}