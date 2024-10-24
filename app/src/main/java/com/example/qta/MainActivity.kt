package com.example.qta

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val firstFragment = firstFragment()
    private val secondFragment = secondFragment()
    private val thirdFragment = thirdFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navigation.setOnNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.firstFragment -> {
                loadFragment(firstFragment)
                true
            }
            R.id.secondFragment -> {
                loadFragment(secondFragment)
                true
            }
            R.id.thirdFragment -> {
                loadFragment(thirdFragment)
                true
            }
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
    }
}
