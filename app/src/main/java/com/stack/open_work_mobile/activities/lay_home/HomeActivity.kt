package com.stack.open_work_mobile.activities.lay_home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.activities.Notify.NotificationActivity
import com.stack.open_work_mobile.activities.Rating.RatingCompanies
import com.stack.open_work_mobile.activities.lay_my_projects.MyProject
import com.stack.open_work_mobile.databinding.ActivityHomeBinding
import com.stack.open_work_mobile.utils.Util


class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(HomeMenuFragment())


        binding.idNotify.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
        binding.bottomNavigationViewHome.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.house_home_id -> replaceFragment(HomeMenuFragment())
                R.id.project_home_id -> replaceFragment(JobsFragment())
                R.id.my_project_home_id -> {
                    val intent = Intent(this, MyProject::class.java)
                    startActivity(intent)
                }

                R.id.avaliation_home_id -> {
                    val intent = Intent(this, RatingCompanies::class.java)
                    startActivity(intent)
                }

                R.id.finance_home_id -> replaceFragment(FinanceFragment())
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





