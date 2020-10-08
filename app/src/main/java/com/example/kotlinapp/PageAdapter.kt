package com.example.kotlinapp

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class PageAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {



    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                Log.e("Adapter","SUM")
                return sumFragment()
            }

            1 -> {
                Log.e("Adapter","SUB")
                return subFragment()
            }

            2 -> {
                Log.e("Adapter","MUL")
                return mulFragment()
            }

            3 -> {
                Log.e("Adapter","DIV")
                return divFragment()
            }
            else -> return sumFragment()
        }
    }

}