package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  inizializeTab()
        setAdapter()
    }

    fun inizializeTab() {
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Somma"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Sottrazzione"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Moltiplicazione"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Divisione"))
    }
    fun setAdapter() {
        val adapter = PageAdapter(supportFragmentManager)
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)

    }
}