package com.example.nutritionfacts.ui.welcomeScreen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import kotlinx.android.synthetic.main.fragment_welcome_screen.*

class WelcomeScreen : Fragment() {

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_welcome_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.hide()



        topAnimation = AnimationUtils.loadAnimation(activity, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(activity, R.anim.bottom_animation)

        image_diet_girl.animation = topAnimation
        welcome_text.animation = bottomAnimation




        Handler().postDelayed({
      (activity as AppCompatActivity).supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_right
                )
                .replace(R.id.nav_host_fragment, FoodAnalysisFragment())
                .commit()
        },6000)




    }

}
