package com.stack.open_work_mobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stack.open_work_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ProgressMenuFragment())


        binding.bottomNavigationView.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.progress_id -> replaceFragment(ProgressMenuFragment())

                R.id.completed_id -> replaceFragment(CompletedMenuFragment())

                R.id.canceled_id -> replaceFragment(CanceledMenuFragment())

            }
            true
        }
        applyIconColorSelectorToMenuIcons(binding.bottomNavigationView)
    }


    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    private fun applyIconColorSelectorToMenuIcons(bottomNavigationView: BottomNavigationView) {
        val menu = bottomNavigationView.menu

        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            val icon = menuItem.icon
            val iconWithTint = icon?.mutate()
            iconWithTint?.setTintList(resources.getColorStateList(R.color.bottom_nav_icon_selector))
            menuItem.icon = iconWithTint
        }


    }
}