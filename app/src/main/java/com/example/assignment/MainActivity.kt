package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.assignment.`interface`.communicator
import com.example.assignment.adapter.ViewPagerAdapter
import com.example.assignment.fragments.AboutFragment
import com.example.assignment.fragments.HomeFragment
import com.example.assignment.fragments.PostFragment
import com.example.assignment.model.student
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        com.example.assignment.`object`.student.loadPost()

        val homeBtn = findViewById<ImageView>(R.id.home_icon)
        val galleryBtn = findViewById<ImageView>(R.id.add_icon)
        val aboutBtn = findViewById<ImageView>(R.id.about_icon)
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, HomeFragment()).commit()
        homeBtn.setOnClickListener(clickListener)
        galleryBtn.setOnClickListener(clickListener)
        aboutBtn.setOnClickListener(clickListener)
    }

    private val clickListener : View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.home_icon -> {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, HomeFragment()).commit()
            }

            R.id.add_icon -> {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, PostFragment()).commit()
            }

            R.id.about_icon -> {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, AboutFragment()).commit()
            }

        }
    }
//
//    override fun passDataCom(editTextInput: String) {
//       val bundle=Bundle()
//        bundle.putString("name",editTextInput)
//        val HomeFragment=HomeFragment()
//        HomeFragment.arguments=bundle
//    }
}