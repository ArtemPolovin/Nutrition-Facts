package com.example.nutritionfacts.ui.welcomeScreen

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nutritionfacts.App
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFactory
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisViewModel
import com.example.nutritionfacts.ui.viewStates.WelcomeScreenViewState
import kotlinx.android.synthetic.main.fragment_welcome_screen.*
import javax.inject.Inject

class WelcomeScreen : Fragment() {

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    companion object{
        var welcomeScreenViewState: WelcomeScreenViewState = WelcomeScreenViewState.Able
    }

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
            welcomeScreenViewState = WelcomeScreenViewState.Unable
            findNavController().navigate(R.id.action_welcome_fragment_to_nav_food_text_analysis2,null)
        },5000)




    }

}
