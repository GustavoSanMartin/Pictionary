package ca.gustavo.pictionary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        button = findViewById(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this@MenuActivity, DrawingActivity::class.java)
            startActivity(intent)
        }
    }
}


