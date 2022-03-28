package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FrameLayoutActivity : AppCompatActivity() {
    private lateinit var text1: TextView
    private lateinit var text2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)

        this.text1 = findViewById(R.id.flTextView1)
        this.text2 = findViewById(R.id.flTextView2)

        this.text1.setOnClickListener{
            this.text1.visibility = View.INVISIBLE
            this.text2.visibility = View.VISIBLE
        }

        this.text2.setOnClickListener{
            this.text1.visibility = View.VISIBLE
            this.text2.visibility = View.INVISIBLE
        }
    }
}