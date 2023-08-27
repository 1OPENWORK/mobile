package com.stack.open_work_mobile.lay_home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.databinding.ActivityHomeBinding


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeMenuFragment())


        binding.bottomNavigationViewHome.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.project_home_id -> replaceFragment(HomeMenuFragment())

            }
            true
        }

        applyIconColorSelectorToMenuIcons(binding.bottomNavigationViewHome)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_home, fragment)
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