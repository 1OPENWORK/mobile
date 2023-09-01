package com.stack.open_work_mobile.lay_home

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.databinding.ActivityHomeBinding
import com.stack.open_work_mobile.utils.Util


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("UseCompatLoadingForColorStateLists")
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
        val select = resources.getColorStateList(R.color.bottom_nav_icon_selector)
        Util.applyIconColor(binding.bottomNavigationViewHome, select)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_home, fragment)
        fragmentTransaction.commit()
    }

}





