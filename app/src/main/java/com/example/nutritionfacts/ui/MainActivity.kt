package com.example.nutritionfacts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nutritionfacts.R
import com.example.nutritionfacts.util.actionToFoodTextAnalysisFragment
import com.example.nutritionfacts.util.actionToGroceryFodAnalysisFragment
import com.example.nutritionfacts.util.actionToRecipeAnalysisFragment
import com.example.nutritionfacts.util.actionToSettingsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_food_text_analysis,
                R.id.nav_recipe_analysis,
                R.id.nav_grocery_food_analysis,
                R.id.nav_settings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        slideFragment()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun slideFragment() {
          navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_food_text_analysis -> {
                    navController.navigate(actionToFoodTextAnalysisFragment(navController.currentDestination))
                   drawerLayout.closeDrawers()
                }
                R.id.nav_grocery_food_analysis -> {
                    navController.navigate(actionToGroceryFodAnalysisFragment(navController.currentDestination))
                    drawerLayout.closeDrawers()
                }
                R.id.nav_recipe_analysis -> {
                    navController.navigate(actionToRecipeAnalysisFragment(navController.currentDestination))
                    drawerLayout.closeDrawers()
                }
                R.id.nav_settings -> {
                    navController.navigate(actionToSettingsFragment(navController.currentDestination))
                    drawerLayout.closeDrawers()
                }
            }
            true
        }
    }


}
