package com.example.nutritionfacts.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat

import com.example.nutritionfacts.R


class SettingsFragment : PreferenceFragmentCompat() {

   override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
      addPreferencesFromResource(R.xml.preferences)
   }

}
