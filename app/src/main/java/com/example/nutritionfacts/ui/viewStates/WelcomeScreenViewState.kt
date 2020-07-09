package com.example.nutritionfacts.ui.viewStates

sealed class WelcomeScreenViewState {

    object Able: WelcomeScreenViewState()

    object Unable: WelcomeScreenViewState()
}