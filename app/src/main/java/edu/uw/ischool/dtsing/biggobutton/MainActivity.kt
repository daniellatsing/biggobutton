package edu.uw.ischool.dtsing.biggobutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var count = 0

    private fun getRandomHexColor(): String {
        val random = Random
        var color = "#"

        for (i in 0..5) {
            color += random.nextInt(16).toString(16)
        }

        return color;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            updateButton()
        }
    }

    private fun updateButtonText(count: Int) : String {
        return if (count == 1) {
            "You have pushed me $count time!"
        } else {
            "You have pushed me $count times!"
        }
    }

    private fun updateButton() {
        val button = findViewById<Button>(R.id.button)
        val backgroundHex = getRandomHexColor()
        val textHex = getRandomHexColor()

        count++

        button.text = updateButtonText(count)

        // change background color
        button.setBackgroundColor(Color.parseColor(backgroundHex))

        // change text color
        button.setTextColor(Color.parseColor(textHex))
    }
}