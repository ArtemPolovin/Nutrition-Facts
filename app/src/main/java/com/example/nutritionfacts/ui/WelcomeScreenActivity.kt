package com.example.nutritionfacts.ui

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.nutritionfacts.R
import kotlinx.android.synthetic.main.activity_welcome_screen.*

class WelcomeScreenActivity : AppCompatActivity() {

    private var topAnimation: Animation? = null
    private var bottomAnimation: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_welcome_screen)
        supportActionBar?.hide()

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        image_diet_girl.animation = topAnimation
        welcome_text.animation = bottomAnimation

        Thread(Runnable {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            startActivity(Intent(applicationContext, MainActivity::class.java))
            overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_right)
            finish()
        }).start()
    }

}
