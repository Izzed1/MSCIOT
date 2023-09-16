package com.unissula.msciot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val SPLASH_DELAY: Long = 3000
        val imageView: ImageView = findViewById(R.id.iv_logo)

        imageView.postDelayed({
            val intent = Intent(this, OnboardingScreenActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}