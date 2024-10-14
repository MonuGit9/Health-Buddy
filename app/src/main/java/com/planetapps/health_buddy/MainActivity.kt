package com.planetapps.health_buddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // by default, home fragment visible
        replaceWithFragment(HomeFragment())

        bottomView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.homeFragment -> replaceWithFragment(HomeFragment())
                R.id.feedFragment -> replaceWithFragment(FeedFragment())
                else -> {
                }
            }
            true
        }
    }

    private fun replaceWithFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}