package com.Dedany.marioapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.Dedany.marioapp.databinding.ActivityFragmentMainBinding





    class MainFragmentActivity : AppCompatActivity() {

        private var binding: ActivityFragmentMainBinding? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding = ActivityFragmentMainBinding.inflate(layoutInflater)
            setContentView(binding?.root)


            // replaceFragment(HeroFragment())

            initiListeners()

        }

        private fun initiListeners() {
            binding?.BottomNavigation?.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_heroes -> replaceFragment(HeroFragment())
                    R.id.navigation_villanos -> replaceFragment(VillainFragment())
                }
                true
            }

        }


        private fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }
    }


