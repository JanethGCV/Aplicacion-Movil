package com.example.modenatres

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var flipButton: Button
    private lateinit var coinImageView: ImageView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flipButton = findViewById(R.id.flipButton)
        coinImageView = findViewById(R.id.coinImageView)
        resultTextView = findViewById(R.id.resultTextView)

        flipButton.setOnClickListener {
            flipCoin()
        }
    }

    private fun flipCoin() {
        val randomNumber = Random.nextInt(2) // 0 para cara, 1 para cruz
        val imageResource = if (randomNumber == 0) {
            R.drawable.cara // R.drawable.cara es el ID de la imagen de la cara en tus recursos
        } else {
            R.drawable.cruz // R.drawable.cruz es el ID de la imagen de la cruz en tus recursos
        }
        coinImageView.setImageResource(imageResource)

        val result = if (randomNumber == 0) {
            "¡Es cara!"
        } else {
            "¡Es cruz!"
        }

        resultTextView.text = result

        // Actualizar el resultado después de 1 segundo
        Handler().postDelayed({
            resultTextView.text = ""
        }, 1000)
    }
}
